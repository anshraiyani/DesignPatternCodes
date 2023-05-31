package com.ansh;

import java.util.ArrayList;

interface Iterator { //blueprint for iterator
    boolean hasNext();
    Object next();
}

class VehicleInfo{ //we create an object of this type to store multiple info about a vehicle owner
    private String type;
    private String numberPlate;
    private String ownerName;

    public VehicleInfo(String type, String numberPlate, String ownerName) {
        this.type = type;
        this.numberPlate = numberPlate;
        this.ownerName = ownerName;
    }
    
    public String getType() {
        return type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getOwnerName() {
        return ownerName;
    }
}

class VehicleRespository{ //contains method to add vehicle info

    private ArrayList<VehicleInfo> vehicles = new ArrayList<VehicleInfo>();

    public void addVehicle(VehicleInfo vehicle) {
        vehicles.add(vehicle);
    }

    public  Iterator getIterator() {
        return new VehicleIterator();
    }

    private class VehicleIterator implements Iterator{ //inner class which defines methods of iterator class
        int index;

        @Override
        public boolean hasNext() {
            return (index < vehicles.toArray().length);
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return vehicles.get(index++);
            }
            return null;
        }
    }

}

public class IteratorDesignPatternClient {
    public static void main(String[] args) {
        VehicleRespository v = new VehicleRespository();
        v.addVehicle(new VehicleInfo("car", "1234", "Ansh"));
        v.addVehicle(new VehicleInfo("bike", "4567", "Ansh"));
        v.addVehicle(new VehicleInfo("car", "0123", "Rahul"));

        Iterator iter = v.getIterator();
        while(iter.hasNext()){
            VehicleInfo vehicleInfo = (VehicleInfo) iter.next();
            System.out.println("Type: "+vehicleInfo.getType()+" Number Plate: "+vehicleInfo.getNumberPlate()+" Owner Name: "+vehicleInfo.getOwnerName());
        }
    }
}