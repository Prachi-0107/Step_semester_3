package abstraction_and_interface.class_problems;

/**
 * Problem 1 (Basic): The Talking Toy Box.
 *
 * Requirements:
 * - Toy must be an abstract class with an abstract method makeSound(),
 *   and a final toyId field assigned via a shared static counter inside its constructor.
 * - ToyCar and ToyRobot must both extend Toy directly and implement makeSound() with genuinely different sounds.
 * - Confirm, through design, that new Toy() cannot compile.
 */
public class TalkingToyBoxDemo {

    public static abstract class Toy {
        private static int counter = 1000;
        private final String toyId;
        protected String name;

        public Toy(String name) {
            this.name = name;
            counter++;
            this.toyId = "TOY-" + counter;
        }

        public abstract String makeSound();

        public String getToyId() {
            return this.toyId;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    public static class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound()); // "Speedster: Vroom vroom!"

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound()); // "Bolt: Beep boop!"

        System.out.println(c.getToyId()); // "TOY-1001"
        System.out.println(r.getToyId()); // "TOY-1002"

        // Demonstrating that Toy cannot be directly instantiated:
        // Toy generic = new Toy("Generic"); // COMPILATION ERROR: Toy is abstract; cannot be instantiated
    }
}
