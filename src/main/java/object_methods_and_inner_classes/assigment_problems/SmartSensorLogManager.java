package object_methods_and_inner_classes.assigment_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Assignment Problem 3: Sensor Hub with Member Inner Class Log Management.
 * Demonstrates:
 * 1. Member inner classes binding directly to outer hub state.
 * 2. Static nested classes acting as standalone data transfer records.
 * 3. Encapsulated lifecycle and memory isolation.
 */
public class SmartSensorLogManager {

    public static class SensorHub {
        private String hubId;
        private String location;
        private List<TelemetryEntry> entries;

        public SensorHub(String hubId, String location) {
            this.hubId = hubId;
            this.location = location;
            this.entries = new ArrayList<>();
        }

        // Static Nested Class: Data transfer object independent of hub instance
        public static class TelemetryReading {
            private double temperature;
            private double humidity;

            public TelemetryReading(double temperature, double humidity) {
                this.temperature = temperature;
                this.humidity = humidity;
            }

            public double getTemperature() {
                return temperature;
            }

            public double getHumidity() {
                return humidity;
            }

            @Override
            public String toString() {
                return String.format("%.1f C, %.1f%% RH", temperature, humidity);
            }
        }

        // Member Inner Class: Directly accesses enclosing SensorHub instance state
        public class TelemetryEntry {
            private String timestamp;
            private TelemetryReading reading;

            public TelemetryEntry(String timestamp, TelemetryReading reading) {
                this.timestamp = timestamp;
                this.reading = reading;
            }

            public void log() {
                // Reaches hubId and location from outer instance
                System.out.printf("[%s @ %s] Time: %s -> %s%n", hubId, location, timestamp, reading);
            }
        }

        public void recordTelemetry(String timestamp, double temp, double humidity) {
            TelemetryReading reading = new TelemetryReading(temp, humidity);
            TelemetryEntry entry = new TelemetryEntry(timestamp, reading);
            entries.add(entry);
            entry.log();
        }

        public int getTotalEntries() {
            return entries.size();
        }
    }

    public static void main(String[] args) {
        SensorHub hub = new SensorHub("HUB-NORTH-01", "Building B Server Room");

        System.out.println("--- Recording Sensor Telemetry ---");
        hub.recordTelemetry("10:00:00", 21.4, 45.0);
        hub.recordTelemetry("10:15:00", 22.1, 46.5);
        hub.recordTelemetry("10:30:00", 21.9, 45.8);

        System.out.println("\nTotal entries logged: " + hub.getTotalEntries());
    }
}
