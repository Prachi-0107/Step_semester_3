package object_methods_and_inner_classes.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Live Walkthrough: Cloning — clone(), Shallow vs Deep Copy.
 * Based on Section 4 of Week 8 Concept Introduction.
 *
 * Demonstrates:
 * 1. Cloneable marker interface requirement to avoid CloneNotSupportedException.
 * 2. Shallow copy behavior where reference fields (e.g., ArrayList) are shared.
 * 3. Deep copy implementation where mutable reference fields are independently duplicated.
 * 4. Composite object cloning (SmartDoorLock owning ScheduleConfig).
 */
public class CloningDemo {

    // Config class representing scheduled times list
    public static class ScheduleConfig implements Cloneable {
        private List<String> scheduledTimes = new ArrayList<>();

        public List<String> getScheduledTimes() {
            return scheduledTimes;
        }

        // Method demonstrating Object's default shallow copy behavior
        public ScheduleConfig shallowClone() throws CloneNotSupportedException {
            return (ScheduleConfig) super.clone(); // copies list reference only
        }

        // Overridden clone() performing a genuine deep copy
        @Override
        public ScheduleConfig clone() throws CloneNotSupportedException {
            ScheduleConfig copy = (ScheduleConfig) super.clone();
            copy.scheduledTimes = new ArrayList<>(this.scheduledTimes); // deep copy the list
            return copy;
        }
    }

    // Composite smart device holding a ScheduleConfig reference
    public static class SmartDoorLock implements Cloneable {
        private String lockId;
        private ScheduleConfig config;

        public SmartDoorLock(String lockId, ScheduleConfig config) {
            this.lockId = lockId;
            this.config = config;
        }

        public String getLockId() {
            return lockId;
        }

        public ScheduleConfig getConfig() {
            return config;
        }

        // True deep copy duplicating both the door lock and its nested configuration
        @Override
        public SmartDoorLock clone() throws CloneNotSupportedException {
            SmartDoorLock copy = (SmartDoorLock) super.clone();
            copy.config = this.config.clone(); // deep copy child object
            return copy;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SECTION 4: Shallow Copy vs Deep Copy ===");

        try {
            // 1. Shallow Copy Test (Reproducing Section 4 "Try This Code")
            System.out.println("\n--- Testing Shallow Copy ---");
            ScheduleConfig originalShallow = new ScheduleConfig();
            originalShallow.getScheduledTimes().add("07:00");
            ScheduleConfig shallowCopy = originalShallow.shallowClone();
            originalShallow.getScheduledTimes().add("22:00");

            // Notice that shallowCopy sees "22:00" because both point to the same ArrayList!
            System.out.println("originalShallow times: " + originalShallow.getScheduledTimes());
            System.out.println("shallowCopy times:     " + shallowCopy.getScheduledTimes()); // [07:00, 22:00]

            // 2. Deep Copy Test (Reproducing Section 4 "The Fix — a Genuine Deep Copy")
            System.out.println("\n--- Testing Genuine Deep Copy ---");
            ScheduleConfig originalDeep = new ScheduleConfig();
            originalDeep.getScheduledTimes().add("07:00");
            ScheduleConfig deepCopy = originalDeep.clone();
            originalDeep.getScheduledTimes().add("22:00");

            // deepCopy retains only [07:00] because it has its own independent ArrayList
            System.out.println("originalDeep times: " + originalDeep.getScheduledTimes()); // [07:00, 22:00]
            System.out.println("deepCopy times:     " + deepCopy.getScheduledTimes());     // [07:00]

            // 3. Composite Device Deep Clone Test
            System.out.println("\n--- Composite SmartDoorLock Deep Clone ---");
            ScheduleConfig masterConfig = new ScheduleConfig();
            masterConfig.getScheduledTimes().add("08:00");
            SmartDoorLock lock1 = new SmartDoorLock("LOCK-01", masterConfig);
            SmartDoorLock lock2 = lock1.clone();

            lock1.getConfig().getScheduledTimes().add("18:00");
            System.out.println("Lock 1 config times: " + lock1.getConfig().getScheduledTimes()); // [08:00, 18:00]
            System.out.println("Lock 2 config times: " + lock2.getConfig().getScheduledTimes()); // [08:00]
            System.out.println("Are config references distinct? " + (lock1.getConfig() != lock2.getConfig()));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
