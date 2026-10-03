package object_methods_and_inner_classes.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Live Walkthrough: Object Class Methods (toString, equals, hashCode).
 * Demonstrates:
 * 1. Default Object.toString() vs custom overridden toString().
 * 2. Reference equality (==) vs Logical content equality (.equals()).
 * 3. The equals/hashCode contract and its effect on hash-based collections (HashSet).
 */
public class ObjectMethodsDemo {

    public static class SmartLight {
        private String deviceId;
        private boolean powerOn;

        public SmartLight(String deviceId) {
            this.deviceId = deviceId;
            this.powerOn = false;
        }

        public void setPower(boolean state) {
            this.powerOn = state;
        }

        public String getDeviceId() {
            return deviceId;
        }

        // 1. Overriding toString() for human-readable state description
        @Override
        public String toString() {
            return "Device{id='" + deviceId + "', powerOn=" + powerOn + "}";
        }

        // 2. Overriding equals() for content comparison
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            SmartLight other = (SmartLight) obj;
            return Objects.equals(this.deviceId, other.deviceId);
        }

        // 3. Overriding hashCode() consistently with equals()
        @Override
        public int hashCode() {
            return Objects.hash(deviceId);
        }
    }

    public static void main(String[] args) {
        SmartLight light1 = new SmartLight("LIGHT-01");
        SmartLight light2 = new SmartLight("LIGHT-01");

        System.out.println("--- toString() Demonstration ---");
        System.out.println(light1); // Custom representation instead of ClassName@hex

        System.out.println("\n--- == vs .equals() Demonstration ---");
        System.out.println("light1 == light2: " + (light1 == light2));             // false: distinct references
        System.out.println("light1.equals(light2): " + light1.equals(light2));     // true: same deviceId

        System.out.println("\n--- HashSet Deduplication (equals + hashCode) ---");
        Set<SmartLight> set = new HashSet<>();
        set.add(light1);
        set.add(light2);
        System.out.println("Unique lights in set: " + set.size()); // 1
    }
}
