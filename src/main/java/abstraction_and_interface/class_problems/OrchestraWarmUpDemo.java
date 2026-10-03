package abstraction_and_interface.class_problems;

/**
 * Problem 3 (Intermediate): Orchestra Warm-Up Routine.
 *
 * Requirements:
 * - Violin extends StringInstrument, StringInstrument extends Instrument (3-level hierarchy).
 * - Subclass constructors call parent constructor using super(...).
 * - Instrument is abstract with abstract play().
 * - StringInstrument overrides play().
 * - Violin overrides play() again.
 * - Each override calls super.play() first and adds its own extra detail.
 */
public class OrchestraWarmUpDemo {

    public static abstract class Instrument {
        public abstract String play();
    }

    public static class StringInstrument extends Instrument {
        public StringInstrument() {
            super();
        }

        @Override
        public String play() {
            return "Strumming the strings";
        }
    }

    public static class Violin extends StringInstrument {
        public Violin() {
            super();
        }

        @Override
        public String play() {
            // Reuses parent message via super.play() and adds specific detail
            return super.play() + ", with a bow drawn across four strings";
        }
    }

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play());

        Violin v = new Violin();
        System.out.println(v.play());
    }
}
