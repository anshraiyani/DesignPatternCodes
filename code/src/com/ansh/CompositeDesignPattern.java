package com.ansh;
import java.util.ArrayList;
import java.util.List;

interface DriverDetails{ //blueprint for code
    void showDetails();
}

class Leaf implements DriverDetails{ // leaf class which contains either details or other components(Driver details)

    int age;
    String name;
    String numberPlate;

    Leaf(String name,int age, String numberPlate){
        this.name=name;
        this.age=age;
        this.numberPlate=numberPlate;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: "+name+" | Age: "+age+" | Number Plate: "+numberPlate);
    }
}

class CompositeBranch implements DriverDetails{ //this class contains array of details and has a proper name
    String branchName;
    List<DriverDetails> driverDetails = new ArrayList<>();

    public CompositeBranch(String branchName){
        super();
        this.branchName=branchName;
    }
    public void addComponent(DriverDetails d){
        driverDetails.add(d);
    }
    @Override
    public void showDetails() {
        System.out.println("\nBranch name: "+branchName);
        System.out.println("Details of Branch "+branchName+"\n");
        for(DriverDetails d: driverDetails){ //this shows all the data in a particular branch
            d.showDetails();
        }
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        CompositeBranch b1 = new CompositeBranch("Gandhinagar"); //main branch
        CompositeBranch b2 = new CompositeBranch("Sector 11"); //sub branch 1
        CompositeBranch b3 = new CompositeBranch("Sector 15"); // sub branch 2

        //below are all the details which we will put in particular branch
        DriverDetails d1 = new Leaf("abc",19,"abcabc");
        DriverDetails d2 = new Leaf("xyz",19,"zyxyzy");
        DriverDetails d3 = new Leaf("str",19,"srtsrs");
        DriverDetails d4 = new Leaf("pqr",19,"pqrpqr");
        DriverDetails d5 = new Leaf("lmn",19,"lmnlmn");

        //adding details to sub branch 1
        b2.addComponent(d1);
        b2.addComponent(d2);

        //adding details to sub branch 2
        b3.addComponent(d3);
        b3.addComponent(d4);
        b3.addComponent(d5);

        //adding sub branches to main branch
        b1.addComponent(b2);
        b1.addComponent(b3);

        //below code will only show details specific to that sub branch only
//        b3.showDetails();
//        b2.showDetails();

        //below code will show details of all sub branches
        b1.showDetails();
    }
}
