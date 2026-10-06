package object_methods_and_inner_classes.class_problems;

/**
 * Live Walkthrough: Inner Classes — Member, Static Nested, Local, Anonymous.
 * Based on Section 5 of Week 8 Concept Introduction.
 *
 * Demonstrates:
 * 1. Member Inner Class: Bound to enclosing outer instance (thermostat.new UsageLog()).
 * 2. Static Nested Class: Independent of outer instance (new SmartThermostat.TemperatureReading(22.5)).
 * 3. Local Inner Class: Scoped entirely inside calibrate() method.
 * 4. Anonymous Inner Class: One-off on-the-spot implementation of Schedulable.
 */
public class InnerClassesDemo {

    public interface Remoteable {
        void connectToApp(String appId);
    }

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public interface EnergyMonitorable {
        double getEnergyUsage();
    }

    // Base abstract class
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

    // SmartThermostat encapsulating member, static nested, and local inner classes
    public static class SmartThermostat extends Device implements Remoteable, Schedulable, EnergyMonitorable {
        private double targetTemp;

        public SmartThermostat(String deviceId, double targetTemp) {
            super(deviceId);
            this.targetTemp = targetTemp;
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("Thermostat [" + getDeviceId() + "] regulating temp to " + targetTemp + "C.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("Thermostat connected to " + appId);
        }

        @Override
        public void scheduleAction(String time) {
            System.out.println("Thermostat scheduled for " + time);
        }

        @Override
        public double getEnergyUsage() {
            return 1.45; // kWh
        }

        // 1. Member Inner Class: Tied to a specific SmartThermostat instance
        public class UsageLog {
            public void record(String event) {
                // Reaches outer instance method getDeviceId() directly without explicit reference
                System.out.println("[" + getDeviceId() + "] " + event);
            }
        }

        // 2. Static Nested Class: No outer instance needed
        public static class TemperatureReading {
            private final double celsius;

            public TemperatureReading(double celsius) {
                this.celsius = celsius;
            }

            public double toFahrenheit() {
                return celsius * 9 / 5 + 32;
            }
        }

        // 3. Local Inner Class: Scoped entirely inside this method
        public void calibrate() {
            class CalibrationOffset {
                double compute(double raw) {
                    return raw - 0.5;
                }
            }

            CalibrationOffset offset = new CalibrationOffset();
            System.out.println("Calibrated: " + offset.compute(23.0));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SECTION 5: Inner Classes Demonstrations ===");

        // 1. Member Inner Class
        System.out.println("\n--- 1. Member Inner Class (UsageLog) ---");
        SmartThermostat thermostat = new SmartThermostat("THERMO-01", 22.5);
        SmartThermostat.UsageLog log = thermostat.new UsageLog();
        log.record("Target changed to 24.0");

        // 2. Static Nested Class
        System.out.println("\n--- 2. Static Nested Class (TemperatureReading) ---");
        SmartThermostat.TemperatureReading reading = new SmartThermostat.TemperatureReading(22.5);
        System.out.println("Converted to Fahrenheit: " + reading.toFahrenheit());

        // 3. Local Inner Class
        System.out.println("\n--- 3. Local Inner Class (CalibrationOffset) ---");
        thermostat.calibrate();

        // 4. Anonymous Inner Class
        System.out.println("\n--- 4. Anonymous Inner Class (Schedulable) ---");
        Schedulable weekendOnly = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Weekend-only schedule set for " + time);
            }
        };
        weekendOnly.scheduleAction("09:00");
    }
}
