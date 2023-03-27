package com.ansh;

// Interface for the RTO system
interface RTOSystem {
    public void registerVehicle(String vehicleNumber, String ownerName);
}

// Existing implementation of the RTO system
class ExistingRTOSystem implements RTOSystem {
    public void registerVehicle(String vehicleNumber, String ownerName) {
        // Implementation details for registering a vehicle using the existing system
        System.out.println("Registering vehicle using the existing RTO system with vehicle number " + vehicleNumber + " and owner name " + ownerName);
    }
}

// Adapter class that adapts the new RTO system to the existing RTO system interface
class NewRTOSystemAdapter implements RTOSystem {
    private NewRTOSystem newRTOSystem;

    public NewRTOSystemAdapter(NewRTOSystem newRTOSystem) {
        this.newRTOSystem = newRTOSystem;
    }

    public void registerVehicle(String vehicleNumber, String ownerName) {
        // Implementation details for adapting the new system to the existing system interface
        newRTOSystem.registerNewVehicle(vehicleNumber, ownerName);
    }
    public NewRTOSystem getNewRTOSystem() {
        return newRTOSystem;
    }

    public void setNewRTOSystem(NewRTOSystem newRTOSystem) {
        this.newRTOSystem = newRTOSystem;
    }
}

// New implementation of the RTO system
class NewRTOSystem {
    public void registerNewVehicle(String vehicleNumber, String ownerName) {
        // Implementation details for registering a vehicle using the new system
        System.out.println("Registering vehicle using the new RTO system with vehicle number " + vehicleNumber + " and owner name " + ownerName);
    }
}

// Example usage of the adapter
public class AdapterDesignPatternClient {
    public static void main(String[] args) {
        // Create an instance of the existing RTO system
        RTOSystem existingSystem = new ExistingRTOSystem();

        // Create an instance of the new RTO system
        NewRTOSystem newSystem = new NewRTOSystem();

        // Create an adapter instance that adapts the new system to the existing system interface
        RTOSystem adapter = new NewRTOSystemAdapter(newSystem);

        // Use the existing system directly
        existingSystem.registerVehicle("GJ06xyz", "Ansh");

        // Use the new system indirectly through the adapter
        adapter.registerVehicle("GJ10abc", "rahul");

        // Change the adapter's new system instance to another instance
        ((NewRTOSystemAdapter) adapter).setNewRTOSystem(new NewRTOSystem());
        adapter.registerVehicle("GJ06mno", "rohan");
    }
}
