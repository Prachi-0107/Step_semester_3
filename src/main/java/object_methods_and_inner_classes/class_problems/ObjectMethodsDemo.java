package object_methods_and_inner_classes.class_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Live Walkthrough: Object Modeling & Methods (toString, equals, hashCode, getClass).
 * Based on Sections 1, 2, and 3 of Week 8 Concept Introduction.
 *
 * Demonstrates:
 * 1. Device abstract base class providing an overridden toString().
 * 2. SmartLight inheriting Device's toString() without overriding it directly.
 * 3. Reference equality (==) vs Logical content equality (.equals()).
 * 4. Safe equals implementation checking instanceof before downcasting.
 * 5. hashCode() contract alignment with equals() for HashSet deduplication.
 */
public class ObjectMethodsDemo {

    // Interfaces representing smart home device capabilities
    public interface Remoteable {
        void connectToApp(String appId);
    }

    public interface Schedulable {
        void scheduleAction(String time);
    }

    // Section 1: Abstract Device Base Class with overridden toString()
    public abstract static class Device {
        private String deviceId;
        private boolean powerOn;

        public Device(String deviceId) {
            this.deviceId = deviceId;
            this.powerOn = false;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public boolean isPowerOn() {
            return powerOn;
        }

        public void turnOn() {
            this.powerOn = true;
        }

        public void turnOff() {
            this.powerOn = false;
        }

        public abstract void performPrimaryAction();

        @Override
        public String toString() {
            return "Device{id='" + deviceId + "', powerOn=" + powerOn + "}";
        }
    }

    // Sections 2 & 3: SmartLight extending Device and implementing capabilities
    public static class SmartLight extends Device implements Remoteable, Schedulable {

        public SmartLight(String deviceId) {
            super(deviceId);
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("SmartLight [" + getDeviceId() + "] emitting light.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("Connecting SmartLight " + getDeviceId() + " to app " + appId);
        }

        @Override
        public void scheduleAction(String time) {
            System.out.println("Scheduling SmartLight " + getDeviceId() + " for " + time);
        }

        // Section 2: Safe equals() implementation with instanceof check
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof SmartLight)) return false;
            SmartLight other = (SmartLight) obj;
            return this.getDeviceId().equals(other.getDeviceId());
        }

        // Section 3: hashCode() overridden consistently using the same field (deviceId)
        @Override
        public int hashCode() {
            return getDeviceId().hashCode();
        }
    }

    // Additional device class to demonstrate instanceof protection
    public static class SmartDoorLock extends Device {
        public SmartDoorLock(String deviceId) {
            super(deviceId);
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("SmartDoorLock [" + getDeviceId() + "] engaging deadbolt.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SECTION 1: Object Modeling & toString() ===");
        SmartLight light = new SmartLight("LIGHT-01");
        // SmartLight inherits Device's toString() override
        System.out.println("Device representation: " + light);

        System.out.println("\n=== SECTION 2: equals() and == vs .equals() ===");
        SmartLight light1 = new SmartLight("LIGHT-01");
        SmartLight light2 = new SmartLight("LIGHT-01");

        // == checks reference identity (different objects in memory)
        System.out.println("light1 == light2: " + (light1 == light2)); // false

        // .equals() checks logical identity (same deviceId)
        System.out.println("light1.equals(light2): " + light1.equals(light2)); // true

        // Type safety test: instanceof prevents ClassCastException
        SmartDoorLock lock = new SmartDoorLock("LOCK-01");
        System.out.println("light1.equals(lock): " + light1.equals(lock)); // false

        System.out.println("\n=== SECTION 3: hashCode() and HashSet Deduplication ===");
        Set<SmartLight> lights = new HashSet<>();
        lights.add(new SmartLight("LIGHT-01"));
        lights.add(new SmartLight("LIGHT-01"));
        System.out.println("Set size after adding equal lights: " + lights.size()); // 1
    }
}
