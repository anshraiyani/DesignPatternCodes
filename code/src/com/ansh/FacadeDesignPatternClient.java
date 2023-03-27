package com.ansh;

interface RTOLicence{ //interface for blueprint of facade
    void generateLicence();
}

// below are different complexities of facade which we will be merging in a single class 'RTOFacade'
class TwoWheelerLicence implements RTOLicence{

    @Override
    public void generateLicence() {
        System.out.println("Generating two wheeler licence");
    }
}

class FourWheelerLicence implements RTOLicence{

    @Override
    public void generateLicence() {
        System.out.println("Generating four wheeler licence");
    }
}

class RTOFacade{ //facade class
    private RTOLicence twoWheelerLicence;
    private RTOLicence fourWheelerLicence;

    RTOFacade(){
        twoWheelerLicence=new TwoWheelerLicence();
        fourWheelerLicence=new FourWheelerLicence();
    }

    void getTwoWheeler(){
        twoWheelerLicence.generateLicence();
    }
    void getFourWheeler(){
        fourWheelerLicence.generateLicence();
    }
}

public class FacadeDesignPatternClient {
    public static void main(String[] args) {
        RTOFacade l1 = new RTOFacade();
        l1.getTwoWheeler();
        l1.getFourWheeler();
    }
}