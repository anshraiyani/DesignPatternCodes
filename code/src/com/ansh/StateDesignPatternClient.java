package com.ansh;
// Define the State interface
interface VehicleState {
    void registerVehicle();
    void deregisterVehicle();
}

// Define the Concrete States
class RegisteredState implements VehicleState {
    private RTOManager rtoManager;

    public RegisteredState(RTOManager rtoManager) {
        this.rtoManager = rtoManager;
    }

    public void registerVehicle() {
        System.out.println("Vehicle is already registered.");
    }

    public void deregisterVehicle() {
        System.out.println("Vehicle deregistered.");
        rtoManager.setState(rtoManager.getDeregisteredState());
    }
}

class DeregisteredState implements VehicleState {
    private RTOManager rtoManager;

    public DeregisteredState(RTOManager rtoManager) {
        this.rtoManager = rtoManager;
    }

    public void registerVehicle() {
        System.out.println("Vehicle registered.");
        rtoManager.setState(rtoManager.getRegisteredState());
    }

    public void deregisterVehicle() {
        System.out.println("Vehicle is already deregistered.");
    }
}

// Define the Context
class RTOManager {
    private VehicleState registeredState;
    private VehicleState deregisteredState;
    private VehicleState currentState;

    public RTOManager() {
        registeredState = new RegisteredState(this);
        deregisteredState = new DeregisteredState(this);
        currentState = deregisteredState; // Default state is Deregistered
    }

    public void registerVehicle() {
        currentState.registerVehicle();
    }

    public void deregisterVehicle() {
        currentState.deregisterVehicle();
    }

    // Allow States to change the current state
    public void setState(VehicleState state) {
        currentState = state;
    }

    public VehicleState getRegisteredState() {
        return registeredState;
    }

    public VehicleState getDeregisteredState() {
        return deregisteredState;
    }
}

// Example usage
public class StateDesignPatternClient{
    public static void main(String[] args) {
        RTOManager rtoManager = new RTOManager();

        rtoManager.registerVehicle();

        rtoManager.registerVehicle();

        rtoManager.deregisterVehicle();

        rtoManager.deregisterVehicle();
    }
}
