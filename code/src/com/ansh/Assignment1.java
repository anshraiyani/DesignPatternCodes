package com.ansh;

interface RTO{ //to provide a blueprint on what RTO does
    void bookTest();
}

class TwoWheeler implements RTO{ //different classes for user to book test for different vehicles
    @Override
    public void bookTest() {
        System.out.println("2 wheeler driving test successfully booked!");
    }
}

class ThreeWheeler implements RTO{
    @Override
    public void bookTest() {
        System.out.println("3 wheeler driving test successfully booked!");
    }
}

class FourWheeler implements RTO{
    @Override
    public void bookTest() {
        System.out.println("4 wheeler driving test successfully booked!");
    }
}

class TestFactory{ //intermediate class Factory which returns object provided proper input
    public RTO bookTest(String s){
        if(s.equalsIgnoreCase("two")){
            return new TwoWheeler();
        }
        else if(s.equalsIgnoreCase("three")){
            return new ThreeWheeler();
        }
        else if(s.equalsIgnoreCase("four")){
            return new FourWheeler();
        }
        return null;
    }
}

public class Assignment1 {
    public static void main(String[] args){
        TestFactory tf1 = new TestFactory();
        RTO test1 = tf1.bookTest("three");
        test1.bookTest();
        RTO test2 = tf1.bookTest("TWO");
        test2.bookTest();
    }
}
