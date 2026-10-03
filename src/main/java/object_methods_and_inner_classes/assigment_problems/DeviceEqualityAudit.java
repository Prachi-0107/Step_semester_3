package object_methods_and_inner_classes.assigment_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Assignment Problem 1: Device Equality Contract Audit.
 * Rigorously verifies all 5 axioms of the Java Object.equals() and hashCode() contract:
 * 1. Reflexive: x.equals(x) == true
 * 2. Symmetric: x.equals(y) == y.equals(x)
 * 3. Transitive: if x.equals(y) and y.equals(z), then x.equals(z) == true
 * 4. Consistent: multiple invocations consistently return the same result
 * 5. Non-nullity: x.equals(null) == false
 * Also verifies hashing behavior in HashSet and HashMap.
 */
public class DeviceEqualityAudit {

    public static class SmartDevice {
        private final String serialNumber;
        private final String model;

        public SmartDevice(String serialNumber, String model) {
            this.serialNumber = serialNumber;
            this.model = model;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public String getModel() {
            return model;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            SmartDevice that = (SmartDevice) obj;
            return Objects.equals(serialNumber, that.serialNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(serialNumber);
        }

        @Override
        public String toString() {
            return "SmartDevice[SN=" + serialNumber + ", model=" + model + "]";
        }
    }

    public static void main(String[] args) {
        SmartDevice d1 = new SmartDevice("SN-1001", "GatewayHub");
        SmartDevice d2 = new SmartDevice("SN-1001", "GatewayHub-RevB");
        SmartDevice d3 = new SmartDevice("SN-1001", "GatewayHub-RevC");
        SmartDevice d4 = new SmartDevice("SN-9999", "SecurityCam");

        System.out.println("--- Verifying Object Contract Axioms ---");
        System.out.println("1. Reflexive (d1.equals(d1)): " + d1.equals(d1));
        System.out.println("2. Symmetric (d1.equals(d2) == d2.equals(d1)): " + (d1.equals(d2) && d2.equals(d1)));
        System.out.println("3. Transitive (d1.equals(d2) && d2.equals(d3) -> d1.equals(d3)): "
                + (d1.equals(d2) && d2.equals(d3) && d1.equals(d3)));
        System.out.println("4. Consistent: " + (d1.equals(d2) == d1.equals(d2)));
        System.out.println("5. Non-nullity (d1.equals(null)): " + d1.equals(null));

        System.out.println("\n--- Collection Hashing Verification ---");
        Set<SmartDevice> deviceSet = new HashSet<>();
        deviceSet.add(d1);
        deviceSet.add(d2);
        deviceSet.add(d3);
        deviceSet.add(d4);
        System.out.println("Unique devices in HashSet (expected 2): " + deviceSet.size());

        Map<SmartDevice, String> registry = new HashMap<>();
        registry.put(d1, "Living Room Hub");
        System.out.println("Retrieved via equivalent d2: " + registry.get(d2));
    }
}
