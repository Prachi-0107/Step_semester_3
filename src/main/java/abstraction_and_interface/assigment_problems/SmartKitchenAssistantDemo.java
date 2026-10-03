package abstraction_and_interface.assigment_problems;

/**
 * Problem 4 (Intermediate): Smart Kitchen Assistant.
 *
 * Requirements:
 * - KitchenTool must be an abstract class with abstract method prepare(),
 *   and a private speedLevel field exposed only through getSpeedLevel()/setSpeedLevel().
 * - setSpeedLevel() must reject any value outside 1-5.
 * - Define interface Washable with method clean() returning a String.
 * - Blender must extend KitchenTool and implement Washable.
 */
public class SmartKitchenAssistantDemo {

    public static abstract class KitchenTool {
        private int speedLevel = 1; // Default speed level within valid range 1-5

        public abstract String prepare();

        public int getSpeedLevel() {
            return this.speedLevel;
        }

        public void setSpeedLevel(int speedLevel) {
            if (speedLevel >= 1 && speedLevel <= 5) {
                this.speedLevel = speedLevel;
            } else {
                System.out.println("Speed level " + speedLevel + " rejected (must be between 1 and 5), speed level stays " + this.speedLevel);
            }
        }
    }

    public interface Washable {
        String clean();
    }

    public static class Blender extends KitchenTool implements Washable {
        public Blender() {
            super();
        }

        @Override
        public String prepare() {
            return "Blending at speed " + getSpeedLevel();
        }

        @Override
        public String clean() {
            return "Blender rinsed and dried";
        }
    }

    public static void main(String[] args) {
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println("Current speed: " + b.getSpeedLevel());

        b.setSpeedLevel(9); // Rejected, stays 3
        System.out.println("After invalid change: " + b.getSpeedLevel());

        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}
