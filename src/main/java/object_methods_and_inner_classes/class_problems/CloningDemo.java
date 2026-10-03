package object_methods_and_inner_classes.class_problems;

/**
 * Live Walkthrough: Object Cloning (Shallow vs Deep Copy).
 * Demonstrates:
 * 1. The Cloneable marker interface and Object.clone().
 * 2. Why shallow copies accidentally share mutable reference fields.
 * 3. Implementing true deep copies by manually duplicating nested objects.
 */
public class CloningDemo {

    public static class ScheduleConfig implements Cloneable {
        public String activeHours;

        public ScheduleConfig(String activeHours) {
            this.activeHours = activeHours;
        }

        @Override
        public ScheduleConfig clone() {
            try {
                return (ScheduleConfig) super.clone();
            } catch (CloneNotSupportedException e) {
                return new ScheduleConfig(this.activeHours);
            }
        }
    }

    public static class SmartDoorLock implements Cloneable {
        private String lockId;
        private ScheduleConfig schedule;

        public SmartDoorLock(String lockId, ScheduleConfig schedule) {
            this.lockId = lockId;
            this.schedule = schedule;
        }

        public ScheduleConfig getSchedule() {
            return schedule;
        }

        public String getLockId() {
            return lockId;
        }

        // Shallow copy: only copies references
        public SmartDoorLock shallowCopy() {
            try {
                return (SmartDoorLock) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        // Deep copy: explicitly clones nested mutable objects
        public SmartDoorLock deepCopy() {
            try {
                SmartDoorLock copy = (SmartDoorLock) super.clone();
                copy.schedule = this.schedule.clone(); // deep copy nested mutable object
                return copy;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Shallow Copy Demonstration ---");
        ScheduleConfig sharedConfig = new ScheduleConfig("08:00 - 20:00");
        SmartDoorLock lock1 = new SmartDoorLock("LOCK-01", sharedConfig);
        SmartDoorLock shallowLock = lock1.shallowCopy();

        // Mutating config via shallow copy
        shallowLock.getSchedule().activeHours = "24/7";
        System.out.println("Original lock1 schedule after shallow mutation: " + lock1.getSchedule().activeHours); // "24/7" (accidental leak!)

        System.out.println("\n--- Deep Copy Demonstration ---");
        ScheduleConfig isolatedConfig = new ScheduleConfig("08:00 - 20:00");
        SmartDoorLock lock2 = new SmartDoorLock("LOCK-02", isolatedConfig);
        SmartDoorLock deepLock = lock2.deepCopy();

        // Mutating config on deep copy
        deepLock.getSchedule().activeHours = "24/7";
        System.out.println("Original lock2 schedule after deep mutation: " + lock2.getSchedule().activeHours); // "08:00 - 20:00" (isolated!)
        System.out.println("Deep cloned lock schedule: " + deepLock.getSchedule().activeHours);                // "24/7"
    }
}
