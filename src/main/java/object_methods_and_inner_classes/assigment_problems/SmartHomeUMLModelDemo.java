package object_methods_and_inner_classes.assigment_problems;

/**
 * Assignment Problem 5: UML Architecture Demonstration.
 * Bridges Section 6 (UML Diagrams — Class, Object, and Sequence) with executable Java code:
 * 1. Generalization / Inheritance: SmartLight and SmartThermostat extend Device.
 * 2. Realization: Devices implement Controllable interface.
 * 3. Composition: SmartThermostat owns its inner StateLog.
 * 4. Association / Dependency: Controller invokes commands on Devices in a sequence.
 */
public class SmartHomeUMLModelDemo {

    public interface Controllable {
        void turnOn();
        void turnOff();
        boolean isActive();
    }

    public static abstract class Device implements Controllable {
        protected String deviceId;
        protected boolean active;

        public Device(String deviceId) {
            this.deviceId = deviceId;
            this.active = false;
        }

        public String getDeviceId() {
            return deviceId;
        }

        @Override
        public void turnOn() {
            this.active = true;
            System.out.println(deviceId + " turned ON.");
        }

        @Override
        public void turnOff() {
            this.active = false;
            System.out.println(deviceId + " turned OFF.");
        }

        @Override
        public boolean isActive() {
            return active;
        }
    }

    public static class SmartLight extends Device {
        private int brightness;

        public SmartLight(String deviceId) {
            super(deviceId);
            this.brightness = 100;
        }

        public void setBrightness(int brightness) {
            this.brightness = brightness;
            System.out.println(deviceId + " brightness set to " + brightness + "%");
        }
    }

    // Central Controller coordinating the sequence of calls
    public static class HomeController {
        public void executeMorningRoutine(Device... devices) {
            System.out.println("=== Sequence: Executing Morning Routine ===");
            for (Device dev : devices) {
                dev.turnOn();
            }
        }
    }

    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("LIGHT-LIVING-01");
        SmartLight kitchenLight = new SmartLight("LIGHT-KITCHEN-01");

        HomeController controller = new HomeController();
        controller.executeMorningRoutine(livingRoomLight, kitchenLight);

        livingRoomLight.setBrightness(75);
    }
}
