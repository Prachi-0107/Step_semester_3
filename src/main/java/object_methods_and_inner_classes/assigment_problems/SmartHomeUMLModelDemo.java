package object_methods_and_inner_classes.assigment_problems;

/**
 * Assignment Problem 5: UML Architecture Demonstration.
 * Direct executable representation of Section 6 (UML Diagrams — Class, Object, and Sequence).
 *
 * Models:
 * 1. Class Diagram Structure:
 *    - Abstract base class Device with private fields and abstract performPrimaryAction().
 *    - Subclasses SmartLight, SmartThermostat, and SmartDoorLock extending Device (Generalization / IS-A).
 *    - Interfaces Remoteable, Schedulable, and EnergyMonitorable (Realization / CAN-DO).
 * 2. Object Diagram Snapshot:
 *    - Runtime instances light1 and thermostat1 holding distinct concrete state.
 * 3. Sequence Diagram Method Interaction Over Time:
 *    - connectAllToApp iterating over Remoteable devices sequentially in a synchronous loop.
 */
public class SmartHomeUMLModelDemo {

    // Interfaces (CAN-DO contracts)
    public interface Remoteable {
        void connectToApp(String appId);
    }

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public interface EnergyMonitorable {
        double getEnergyUsage();
    }

    // Abstract Class Device (IS-A blueprint)
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
            System.out.println(deviceId + " turned ON.");
        }

        public void turnOff() {
            this.powerOn = false;
            System.out.println(deviceId + " turned OFF.");
        }

        public abstract void performPrimaryAction();

        @Override
        public String toString() {
            return "Device{id='" + deviceId + "', powerOn=" + powerOn + "}";
        }
    }

    // Subclass 1: SmartLight
    public static class SmartLight extends Device implements Remoteable, Schedulable {
        public SmartLight(String deviceId) {
            super(deviceId);
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("SmartLight [" + getDeviceId() + "] illuminates room.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("SmartLight [" + getDeviceId() + "] connected to application: " + appId);
        }

        @Override
        public void scheduleAction(String time) {
            System.out.println("SmartLight [" + getDeviceId() + "] set timer for " + time);
        }
    }

    // Subclass 2: SmartThermostat
    public static class SmartThermostat extends Device implements Remoteable, Schedulable, EnergyMonitorable {
        private double targetTemp;

        public SmartThermostat(String deviceId, double targetTemp) {
            super(deviceId);
            this.targetTemp = targetTemp;
        }

        public double getTargetTemp() {
            return targetTemp;
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("SmartThermostat [" + getDeviceId() + "] regulating temp to " + targetTemp + "C.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("SmartThermostat [" + getDeviceId() + "] connected to application: " + appId);
        }

        @Override
        public void scheduleAction(String time) {
            System.out.println("SmartThermostat [" + getDeviceId() + "] set schedule for " + time);
        }

        @Override
        public double getEnergyUsage() {
            return 1.8;
        }
    }

    // Subclass 3: SmartDoorLock
    public static class SmartDoorLock extends Device implements Remoteable {
        public SmartDoorLock(String deviceId) {
            super(deviceId);
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("SmartDoorLock [" + getDeviceId() + "] deadbolt secured.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("SmartDoorLock [" + getDeviceId() + "] connected to application: " + appId);
        }
    }

    /**
     * Executes the exact sequence diagram flow from Page 9-10 of the Concept Guide:
     * main -> connectAllToApp -> light.connectToApp() -> return -> lock.connectToApp() -> return
     */
    public static void connectAllToApp(String appId, Remoteable... devices) {
        System.out.println("[Sequence] connectAllToApp initiated for appId: " + appId);
        for (Remoteable device : devices) {
            device.connectToApp(appId); // synchronous call and return
        }
        System.out.println("[Sequence] connectAllToApp completed all connections.");
    }

    public static void main(String[] args) {
        System.out.println("=== 1. UML CLASS DIAGRAM & OBJECT SNAPSHOT ===");
        // Object Diagram snapshot as shown on Page 9:
        // light1 : SmartLight (deviceId = "LIGHT-01", powerOn = true)
        // thermostat1 : SmartThermostat (deviceId = "THERMO-01", targetTemp = 22.5)
        SmartLight light1 = new SmartLight("LIGHT-01");
        light1.turnOn();

        SmartThermostat thermostat1 = new SmartThermostat("THERMO-01", 22.5);

        System.out.println("Object snapshot 1: " + light1 + ", isPowerOn=" + light1.isPowerOn());
        System.out.println("Object snapshot 2: " + thermostat1 + ", targetTemp=" + thermostat1.getTargetTemp());

        System.out.println("\n=== 2. UML SEQUENCE DIAGRAM EXECUTION ===");
        // Sequence Diagram scenario as shown on Page 9-10:
        // main calls connectAllToApp with light1 and a SmartDoorLock
        SmartDoorLock lock = new SmartDoorLock("LOCK-01");
        connectAllToApp("SmartHomeCentralApp-v2", light1, lock);
    }
}
