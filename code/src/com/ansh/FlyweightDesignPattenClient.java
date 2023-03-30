package com.ansh;

class Vehicle { // contains getters and constructor for our RTO implementation
    private String ownerName;
    private String registrationNumber;
    private VehicleType type;

    public Vehicle(String registrationNumber, String ownerName, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public VehicleType getType() {
        return type;
    }
}

class VehicleType { //separate class of repeated values.
    private String name;

    public VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class VehicleFactory { //contains array of values which are repeated multiple times in the object creation of Vehicle
    private static VehicleType[] vehicleTypes = new VehicleType[2];

    static {
        vehicleTypes[0] = new VehicleType("car");
        vehicleTypes[1] = new VehicleType("bike");
    }

    public static Vehicle getVehicle(String type, String registrationNumber, String ownerName) {
        VehicleType vehicleType = null;

        for (int i = 0; i < vehicleTypes.length; i++) { //iterates through `vehicleTypes` array and assigns proper value to vehicleType when user entered vehicle type is matched.
            if (vehicleTypes[i].getName().equals(type)) {
                vehicleType = vehicleTypes[i];
                break;
            }
        }

        if (vehicleType == null) { //edge case:vehicle type might be null
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }

        return new Vehicle(registrationNumber, ownerName, vehicleType);
    }
}

public class FlyweightDesignPattenClient {

    public static void main(String[] args) {
        Vehicle car1 = VehicleFactory.getVehicle("car", "GJ062033", "Ansh");
        Vehicle bike1 = VehicleFactory.getVehicle("bike", "GJ012011", "Rahul");

        System.out.println(car1.getType().getName());
        System.out.println(bike1.getType().getName());
    }
}