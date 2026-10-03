package abstraction_and_interface.assigment_problems;

/**
 * Problem 5 (Intermediate): Package Drop-Off Log.
 *
 * Requirements:
 * - DeliveryNote must be an abstract class with abstract confirmDelivery(),
 *   plus overloaded confirmDelivery(String signature) chaining internally.
 * - ParcelNote and LetterNote extend DeliveryNote directly and implement confirmDelivery().
 * - Static method logAll(DeliveryNote[] notes) that loops and calls confirmDelivery() polymorphically.
 */
public class PackageDropOffLogDemo {

    public static abstract class DeliveryNote {
        protected String trackingId;

        public DeliveryNote(String trackingId) {
            this.trackingId = trackingId;
        }

        public abstract String confirmDelivery();

        // Overloaded confirmDelivery for compile-time polymorphism
        public String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }

        public String getTrackingId() {
            return trackingId;
        }
    }

    public static class ParcelNote extends DeliveryNote {
        public ParcelNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }

    public static class LetterNote extends DeliveryNote {
        public LetterNote(String trackingId) {
            super(trackingId);
        }

        @Override
        public String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));

        System.out.println("\n--- Polymorphic Batch Logging ---");
        DeliveryNote ref = p; // upcasting: ParcelNote stored as its parent type
        logAll(new DeliveryNote[]{ ref, new LetterNote("TRK-2") });
    }
}
