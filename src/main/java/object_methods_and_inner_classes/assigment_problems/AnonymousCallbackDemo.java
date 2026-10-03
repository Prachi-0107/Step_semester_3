package object_methods_and_inner_classes.assigment_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Assignment Problem 4: Event-Driven Smart Home with Anonymous Inner Classes.
 * Demonstrates:
 * 1. Interface callback registration.
 * 2. Creating multiple distinct event handlers using anonymous inner classes on-the-spot.
 * 3. Event dispatching and loose coupling.
 */
public class AnonymousCallbackDemo {

    public interface DeviceEventListener {
        void onEventTriggered(String eventType, String payload);
    }

    public static class EventDispatcher {
        private List<DeviceEventListener> listeners = new ArrayList<>();

        public void registerListener(DeviceEventListener listener) {
            listeners.add(listener);
        }

        public void fireEvent(String eventType, String payload) {
            for (DeviceEventListener listener : listeners) {
                listener.onEventTriggered(eventType, payload);
            }
        }
    }

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();

        // 1. Anonymous Inner Class for Security Intrusion Monitoring
        dispatcher.registerListener(new DeviceEventListener() {
            @Override
            public void onEventTriggered(String eventType, String payload) {
                if (eventType.equals("MOTION_DETECTED")) {
                    System.out.println("[SECURITY ALERT] Triggered: " + payload + " -> Sounding siren!");
                }
            }
        });

        // 2. Anonymous Inner Class for Power Management Logging
        dispatcher.registerListener(new DeviceEventListener() {
            @Override
            public void onEventTriggered(String eventType, String payload) {
                if (eventType.startsWith("POWER_")) {
                    System.out.println("[ENERGY AUDIT] Event: " + eventType + " | Data: " + payload);
                }
            }
        });

        // 3. Anonymous Inner Class for Emergency Shutdown Handler
        dispatcher.registerListener(new DeviceEventListener() {
            @Override
            public void onEventTriggered(String eventType, String payload) {
                if (eventType.equals("SMOKE_DETECTED")) {
                    System.out.println("[EMERGENCY DISPATCH] " + payload + " -> Unlocking all doors!");
                }
            }
        });

        System.out.println("--- Dispatching Events ---");
        dispatcher.fireEvent("MOTION_DETECTED", "Zone 4 Backdoor");
        dispatcher.fireEvent("POWER_SPIKE", "Voltage surge detected on Phase 2");
        dispatcher.fireEvent("SMOKE_DETECTED", "Kitchen Smoke Alarm Active");
    }
}
