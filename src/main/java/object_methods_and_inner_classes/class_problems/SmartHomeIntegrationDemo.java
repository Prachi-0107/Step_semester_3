package object_methods_and_inner_classes.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Wrap-Up: The Whole Smart Home, Part 2 — In One Program.
 * Directly implements Page 11 of the Week 8 Concept Guide.
 * Unifies toString(), equals(), hashCode(), HashSet, Member Inner Classes,
 * Static Nested Classes, and Anonymous Inner Classes in one end-to-end program.
 */
public class SmartHomeIntegrationDemo {

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public static class SmartLight {
        private String id;
        private boolean powerOn;

        public SmartLight(String id) {
            this.id = id;
            this.powerOn = false;
        }

        @Override
        public String toString() {
            return "Device{id='" + id + "', powerOn=" + powerOn + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SmartLight that = (SmartLight) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class SmartThermostat {
        private String thermostatId;
        private double temperature;

        public SmartThermostat(String thermostatId, double temperature) {
            this.thermostatId = thermostatId;
            this.temperature = temperature;
        }

        // Member Inner Class
        public class UsageLog {
            public void record(String message) {
                System.out.println("[" + thermostatId + "] " + message);
            }
        }

        // Static Nested Class
        public static class TemperatureReading {
            private double celsius;

            public TemperatureReading(double celsius) {
                this.celsius = celsius;
            }

            public double toFahrenheit() {
                return (celsius * 9.0 / 5.0) + 32.0;
            }
        }
    }

    public static void main(String[] args) {
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
