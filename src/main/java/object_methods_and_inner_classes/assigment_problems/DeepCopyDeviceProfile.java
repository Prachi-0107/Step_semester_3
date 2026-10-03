package object_methods_and_inner_classes.assigment_problems;

/**
 * Assignment Problem 2: Deep Copy Device Configuration Profiles.
 * Demonstrates:
 * 1. Cloneable interface implementation.
 * 2. Deep copy recursion across composite child objects.
 * 3. Isolation guarantee preventing mutational cross-contamination.
 */
public class DeepCopyDeviceProfile {

    public static class SecuritySettings implements Cloneable {
        private String encryptionStandard;
        private int pinCode;

        public SecuritySettings(String encryptionStandard, int pinCode) {
            this.encryptionStandard = encryptionStandard;
            this.pinCode = pinCode;
        }

        public void setPinCode(int pinCode) {
            this.pinCode = pinCode;
        }

        public int getPinCode() {
            return pinCode;
        }

        public String getEncryptionStandard() {
            return encryptionStandard;
        }

        @Override
        public SecuritySettings clone() {
            try {
                return (SecuritySettings) super.clone();
            } catch (CloneNotSupportedException e) {
                return new SecuritySettings(this.encryptionStandard, this.pinCode);
            }
        }
    }

    public static class DeviceProfile implements Cloneable {
        private String profileName;
        private SecuritySettings security;

        public DeviceProfile(String profileName, SecuritySettings security) {
            this.profileName = profileName;
            this.security = security;
        }

        public SecuritySettings getSecurity() {
            return security;
        }

        public String getProfileName() {
            return profileName;
        }

        // True deep copy implementation
        @Override
        public DeviceProfile clone() {
            try {
                DeviceProfile cloned = (DeviceProfile) super.clone();
                cloned.security = this.security.clone(); // explicitly deep-clone nested security settings
                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("Cloning failed");
            }
        }
    }

    public static void main(String[] args) {
        SecuritySettings sec = new SecuritySettings("WPA3-AES", 1234);
        DeviceProfile master = new DeviceProfile("Master-LivingRoom", sec);

        // Create independent deep copy
        DeviceProfile clone = master.clone();

        System.out.println("Initial Master PIN: " + master.getSecurity().getPinCode());
        System.out.println("Initial Clone PIN: " + clone.getSecurity().getPinCode());

        // Mutate clone's security settings
        System.out.println("\nModifying Clone's PIN code to 9876...");
        clone.getSecurity().setPinCode(9876);

        System.out.println("Master PIN (remains untouched): " + master.getSecurity().getPinCode());
        System.out.println("Clone PIN (updated): " + clone.getSecurity().getPinCode());
        System.out.println("Memory references identical? " + (master.getSecurity() == clone.getSecurity())); // false
    }
}
