package object_methods_and_inner_classes.class_problems;

/**
 * Live Walkthrough: Member Inner Classes, Static Nested Classes, and Local Inner Classes.
 * Demonstrates:
 * 1. Member Inner Class: bound to enclosing instance, accesses outer private state (SmartThermostat.UsageLog).
 * 2. Static Nested Class: independent of outer instance, acts as package-level helper (SmartThermostat.TemperatureReading).
 * 3. Local Inner Class: scoped entirely inside a method body (CalibrationOffset).
 */
public class InnerClassesDemo {

    public static class SmartThermostat {
        private String thermostatId;
        private double currentTemperature;

        public SmartThermostat(String thermostatId, double currentTemperature) {
            this.thermostatId = thermostatId;
            this.currentTemperature = currentTemperature;
        }

        // 1. Member Inner Class (non-static): belongs to a specific outer instance
        public class UsageLog {
            public void record(String message) {
                // Directly accesses outer instance private field 'thermostatId'
                System.out.println("[" + thermostatId + "] " + message);
            }
        }

        // 2. Static Nested Class: does not require an enclosing outer instance
        public static class TemperatureReading {
            private double celsius;

            public TemperatureReading(double celsius) {
                this.celsius = celsius;
            }

            public double toFahrenheit() {
                return (celsius * 9.0 / 5.0) + 32.0;
            }
        }

        // 3. Method containing a Local Inner Class
        public double calibrate(double rawReading) {
            class CalibrationOffset {
                double compute(double raw) {
                    return raw - 0.5; // Calibration formula
                }
            }

            CalibrationOffset offset = new CalibrationOffset();
            return offset.compute(rawReading);
        }
    }

    public static void main(String[] args) {
        SmartThermostat thermo = new SmartThermostat("THERMO-01", 22.5);

        // Instantiating Member Inner Class via outer object reference
        SmartThermostat.UsageLog log = thermo.new UsageLog();
        log.record("Startup complete");

        // Instantiating Static Nested Class directly
        SmartThermostat.TemperatureReading reading = new SmartThermostat.TemperatureReading(22.5);
        System.out.println("In Fahrenheit: " + reading.toFahrenheit());

        // Calling method with Local Inner Class
        double calibrated = thermo.calibrate(23.0);
        System.out.println("Calibrated Temp: " + calibrated);
    }
}
