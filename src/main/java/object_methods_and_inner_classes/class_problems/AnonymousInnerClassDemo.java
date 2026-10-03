package object_methods_and_inner_classes.class_problems;

/**
 * Live Walkthrough: Anonymous Inner Classes.
 * Demonstrates:
 * 1. Defining and instantiating an interface implementation on-the-spot without a named class.
 * 2. Supplying custom behavioral callbacks (e.g. Schedulable).
 */
public class AnonymousInnerClassDemo {

    public interface Schedulable {
        void scheduleAction(String time);
    }

    public static void main(String[] args) {
        // Anonymous Inner Class implementing Schedulable on-the-spot
        Schedulable weekendOnly = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Weekend-only schedule set for " + time);
            }
        };

        weekendOnly.scheduleAction("09:00");

        // Another anonymous instance with different behavior
        Schedulable nightShift = new Schedulable() {
            @Override
            public void scheduleAction(String time) {
                System.out.println("Night-shift eco power mode engaged at " + time);
            }
        };

        nightShift.scheduleAction("23:30");
    }
}
