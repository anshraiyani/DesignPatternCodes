package com.ansh;

import java.util.ArrayList;
import java.util.List;

// concrete class for scheduling tests.
// one test can be given by many people, so we notify them when a test is generated.
class VehicleTest{
    private List<Person> personList= new ArrayList<>();
    String testName;

    void allocateTest(Person person){
        personList.add(person);
    }

    void deallocateTest(Person person){
        personList.remove(person);
    }

    void notifyPerson(){
        for (Person person: personList){
            person.upadate();
        }
    }

    void generateTest(String testName){
        this.testName=testName;
        notifyPerson();
    }

}

// concrete class for person containing info about a person.
// a person can register for a test and will be notified when test is generated.
class Person{
    private String name;
    private VehicleTest test;

    Person(String name){
        super();
        this.name=name;
    }

    void upadate(){
        System.out.println(name+": "+test.testName+" test Scheduled");
    }

    void registerTest(VehicleTest test){
        this.test=test;
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        VehicleTest test1 = new VehicleTest();
        VehicleTest test2 = new VehicleTest();

        Person p1 = new Person("Ansh");
        Person p2 = new Person("Rahul");
        Person p3 = new Person("Raj");
        Person p4 = new Person("Rohan");
        Person p5 = new Person("Roy");

        p1.registerTest(test1);
        p2.registerTest(test1);
        p3.registerTest(test1);

        test1.allocateTest(p1);
        test1.allocateTest(p2);
        test1.allocateTest(p3);

        p4.registerTest(test2);
        p5.registerTest(test2);

        test2.allocateTest(p4);
        test2.allocateTest(p5);

        test1.generateTest("4 wheeler");
        System.out.println("");
        test2.generateTest("2 wheeler");
    }
}
