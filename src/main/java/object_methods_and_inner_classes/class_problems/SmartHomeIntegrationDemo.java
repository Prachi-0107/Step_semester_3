package object_methods_and_inner_classes.class_problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Wrap-Up: The Whole Smart Home, Part 2 — In One Program.
 * Directly implements Page 11 of the Week 8 Concept Guide.
 *
 * Integrates all concepts in one cohesive ecosystem:
 * - Device abstract class & inherited toString()
 * - equals() & hashCode() consistency with HashSet deduplication
 * - Member Inner Class (UsageLog) accessing outer instance state
 * - Static Nested Class (TemperatureReading) independent of outer instance
 * - Anonymous Inner Class implementing Schedulable on-the-spot
 *
 * Expected Output:
 * Device{id='LIGHT-01', powerOn=false}
 * false
 * true
 * Unique lights stored: 1
 * [THERMO-01] Startup complete
 * In Fahrenheit: 72.5
 * Weekend-only schedule set for 09:00
 */
public class SmartHomeIntegrationDemo {

    // Common abstract base class for smart home devices
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

    public interface Remoteable {
        void connectToApp(String appId);
    }

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public interface EnergyMonitorable {
        double getEnergyUsage();
    }

    // SmartLight extending Device and implementing capabilities
    public static class SmartLight extends Device implements Remoteable, Schedulable {
        public SmartLight(String deviceId) {
            super(deviceId);
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("Light [" + getDeviceId() + "] turned on.");
        }

        @Override
        public void connectToApp(String appId) {
            System.out.println("Light connected to " + appId);
        }

        @Override
        public void scheduleAction(String time) {
            System.out.println("Light scheduled for " + time);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof SmartLight)) return false;
            SmartLight other = (SmartLight) obj;
            return this.getDeviceId().equals(other.getDeviceId());
        }

        @Override
        public int hashCode() {
            return getDeviceId().hashCode();
        }
    }

    // SmartThermostat extending Device with Member Inner Class and Static Nested Class
    public static class SmartThermostat extends Device implements Remoteable, Schedulable, EnergyMonitorable {
        private double targetTemp;

        public SmartThermostat(String deviceId, double targetTemp) {
            super(deviceId);
            this.targetTemp = targetTemp;
        }

        @Override
        public void performPrimaryAction() {
            System.out.println("Thermostat regulating temperature.");
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
            return 2.5;
        }

        // Member Inner Class: bound to outer instance
        public class UsageLog {
            public void record(String event) {
                System.out.println("[" + getDeviceId() + "] " + event);
            }
        }

        // Static Nested Class: independent of outer instance
        public static class TemperatureReading {
            private final double celsius;

            public TemperatureReading(double celsius) {
                this.celsius = celsius;
            }

            public double toFahrenheit() {
                return celsius * 9 / 5 + 32;
            }
        }
    }

    public static void main(String[] args) {
        // Page 11 execution block:
        SmartLight light1 = new SmartLight("LIGHT-01");
        SmartLight light2 = new SmartLight("LIGHT-01");

        System.out.println(light1);
        System.out.println(light1 == light2);
        System.out.println(light1.equals(light2));

        Set<SmartLight> lights = new HashSet<>();
        lights.add(light1);
        lights.add(light2);
        System.out.println("Unique lights stored: " + lights.size());

        SmartThermostat thermostat = new SmartThermostat("THERMO-01", 22.5);
        SmartThermostat.UsageLog log = thermostat.new UsageLog();
        log.record("Startup complete");

        SmartThermostat.TemperatureReading reading = new SmartThermostat.TemperatureReading(22.5);
        System.out.println("In Fahrenheit: " + reading.toFahrenheit());

        Schedulable weekendOnly = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Weekend-only schedule set for " + time);
            }
        };
        weekendOnly.scheduleAction("09:00");
    }
}
