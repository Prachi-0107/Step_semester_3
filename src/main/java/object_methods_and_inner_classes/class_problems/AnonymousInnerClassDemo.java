package object_methods_and_inner_classes.class_problems;

/**
 * Live Walkthrough: Anonymous Inner Classes.
 * Based on Section 5 (Anonymous Inner Class) of Week 8 Concept Introduction.
 *
 * Demonstrates:
 * 1. Defining and instantiating an interface implementation on-the-spot without a named class.
 * 2. Supplying custom one-off behavioral callbacks (e.g., Schedulable, DeviceAction).
 * 3. Passing anonymous inner classes as arguments directly to service methods.
 */
public class AnonymousInnerClassDemo {

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public interface DeviceAction {
        void execute();
    }

    public static class DeviceController {
        public static void runAction(String actionName, DeviceAction action) {
            System.out.println("Initiating controller action: " + actionName);
            action.execute();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SECTION 5: Anonymous Inner Class Walkthrough ===");

        // 1. Standalone anonymous class assigned to a reference variable
        Schedulable weekendOnly = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Weekend-only schedule set for " + time);
            }
        };
        weekendOnly.scheduleAction("09:00");

        // 2. Another anonymous class with custom behavior
        Schedulable vacationMode = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Vacation eco-power routine locked until " + time);
            }
        };
        vacationMode.scheduleAction("18:00");

        // 3. Passing anonymous class directly as method argument
        DeviceController.runAction("Emergency Evacuation", new DeviceAction() {
            @Override
            public void execute() {
                System.out.println("[ACTION EXECUTED] Flashing all perimeter strobe lights and disengaging fire doors.");
            }
        });
    }
}
