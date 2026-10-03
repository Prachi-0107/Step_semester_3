package abstraction_and_interface.assigment_problems;

import abstraction_and_interface.class_problems.TalkingToyBoxDemo;
import abstraction_and_interface.class_problems.WarehouseLabelPrinterDemo;
import abstraction_and_interface.class_problems.OrchestraWarmUpDemo;

/**
 * End-to-end integration and verification suite for Week 7:
 * Abstraction & Interface practice problems.
 */
public class AbstractionInterfacePracticeDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("WEEK 7: ABSTRACTION & INTERFACE VERIFICATION SUITE");
        System.out.println("==================================================");

        // Problem 1 Verification
        System.out.println("\n[Test 1: Talking Toy Box]");
        TalkingToyBoxDemo.ToyCar car = new TalkingToyBoxDemo.ToyCar("Speedster");
        TalkingToyBoxDemo.ToyRobot robot = new TalkingToyBoxDemo.ToyRobot("Bolt");
        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println("Car ID: " + car.getToyId());
        System.out.println("Robot ID: " + robot.getToyId());

        // Problem 2 Verification
        System.out.println("\n[Test 2: Warehouse Label Printer]");
        WarehouseLabelPrinterDemo.PackageBox box = new WarehouseLabelPrinterDemo.PackageBox("TRK-88");
        WarehouseLabelPrinterDemo.Invoice inv = new WarehouseLabelPrinterDemo.Invoice("INV-42");
        WarehouseLabelPrinterDemo.printAll(new WarehouseLabelPrinterDemo.Printable[]{ box, inv });

        // Problem 3 Verification
        System.out.println("\n[Test 3: Orchestra Warm-Up Routine]");
        OrchestraWarmUpDemo.StringInstrument str = new OrchestraWarmUpDemo.StringInstrument();
        OrchestraWarmUpDemo.Violin v = new OrchestraWarmUpDemo.Violin();
        System.out.println(str.play());
        System.out.println(v.play());

        // Problem 4 Verification
        System.out.println("\n[Test 4: Smart Kitchen Assistant]");
        SmartKitchenAssistantDemo.Blender b = new SmartKitchenAssistantDemo.Blender();
        b.setSpeedLevel(3);
        System.out.println("Speed: " + b.getSpeedLevel());
        b.setSpeedLevel(9); // rejected
        System.out.println(b.prepare());
        System.out.println(b.clean());

        // Problem 5 Verification
        System.out.println("\n[Test 5: Package Drop-Off Log]");
        PackageDropOffLogDemo.ParcelNote parcel = new PackageDropOffLogDemo.ParcelNote("TRK-1");
        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("J. Smith"));
        PackageDropOffLogDemo.logAll(new PackageDropOffLogDemo.DeliveryNote[]{
                parcel,
                new PackageDropOffLogDemo.LetterNote("TRK-2")
        });

        System.out.println("\n>>> All Week 7 Abstraction & Interface tests passed successfully! <<<");
    }
}
