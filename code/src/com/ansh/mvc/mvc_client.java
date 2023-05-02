package com.ansh.mvc;

// Vehicle model class
class Vehicle {
    private String regNumber;
    private String ownerName;

    // Constructor
    public Vehicle(String regNumber, String ownerName) {
        this.regNumber = regNumber;
        this.ownerName = ownerName;
    }

    // Getters and Setters
    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

// Vehicle view class
class VehicleView {
        public void printVehicleDetails(String regNumber, String ownerName) {
        System.out.println("Vehicle Details:");
        System.out.println("Registration Number: " + regNumber);
        System.out.println("Owner Name: " + ownerName);
    }
}

// Vehicle controller class
class VehicleController {
    private Vehicle model;
    private VehicleView view;

    // Constructor
    public VehicleController(Vehicle model, VehicleView view) {
        this.model = model;
        this.view = view;
    }

    public void setVehicleOwnerName(String ownerName) {
        model.setOwnerName(ownerName);
    }

    public String getVehicleOwnerName() {
        return model.getOwnerName();
    }

    public void updateView() {
        view.printVehicleDetails(model.getRegNumber(), model.getOwnerName());
    }
}

// RTO application class
class RTOApp {
    public static void main(String[] args) {
        // Create a vehicle model
        Vehicle vehicle = new Vehicle("GJ-06-2003", "");

        // Create a vehicle view
        VehicleView view = new VehicleView();

        // Create a vehicle controller
        VehicleController controller = new VehicleController(vehicle, view);

        // Update the vehicle owner name
        controller.setVehicleOwnerName("Ansh Raiyani");

        // Update the view
        controller.updateView();
    }
}
