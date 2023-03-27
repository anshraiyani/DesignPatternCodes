package com.ansh;

enum TestBooking{
    INSTANCE;
    String name;
    public String getTest(){
        return name;
    }
    public void bookTest(String name){
        this.name=name;
    }
}

public class EnumSingleton {
    public static void main(String[] args) {
        TestBooking t1 = TestBooking.INSTANCE;
        t1.bookTest("Ansh");
        System.out.println("Test booked for "+t1.getTest());
        TestBooking t2 = TestBooking.INSTANCE;
        t2.bookTest("Rahul");
        System.out.println("Test booked for "+t1.getTest());
    }
}
