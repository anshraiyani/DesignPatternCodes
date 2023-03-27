package com.ansh;

interface DriverTest{
    void bookTest();
}

class TwoWheelerTest implements DriverTest{

    @Override
    public void bookTest() {
        System.out.println("Booked two wheeler test");
    }
}
class FourWheelerTest implements DriverTest{

    @Override
    public void bookTest() {
        System.out.println("Booked four wheeler test");
    }
}

interface DriverLicence{
    void orderLicence();
}

class NewLicence implements DriverLicence{

    @Override
    public void orderLicence() {
        System.out.println("Ordered a new drivers licence");
    }
}

class RenewLicence implements DriverLicence{

    @Override
    public void orderLicence() {
        System.out.println("licence issued for a renewal");
    }
}

abstract class AbstractFactory{
    abstract DriverTest getTest(String type);
    abstract DriverLicence getLicence(String type);
}

class DriverTestFactory extends AbstractFactory{

    @Override
    DriverTest getTest(String type) {
        if (type == null) return null;
        else if(type.equalsIgnoreCase("Two")) return new TwoWheelerTest();
        else if(type.equalsIgnoreCase("Four")) return new FourWheelerTest();
        return null;
    }

    @Override
    DriverLicence getLicence(String type) {
        return null;
    }
}

class DriverLicenceFactory extends AbstractFactory{

    @Override
    DriverTest getTest(String type) {
        return null;
    }

    @Override
    DriverLicence getLicence(String type) {
        if (type == null) return null;
        else if(type.equalsIgnoreCase("New")) return new NewLicence();
        else if(type.equalsIgnoreCase("Renew")) return new RenewLicence();
        return null;
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("Test")) return new DriverTestFactory();
        else if(choice.equalsIgnoreCase("Licence")) return new DriverLicenceFactory();
        return null;
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        AbstractFactory testFactory = FactoryProducer.getFactory("test");
        DriverTest test1 = testFactory.getTest("Two");
        test1.bookTest();
        AbstractFactory testFactory2 = FactoryProducer.getFactory("Licence");
        DriverLicence l1 = testFactory2.getLicence("new");
        l1.orderLicence();
    }
}
