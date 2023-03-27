package com.ansh;

class LazySingletonLicence{
    private static LazySingletonLicence obj;
    private String name;
    private LazySingletonLicence(String name){
        this.name=name;
    }
    public static LazySingletonLicence getInstance(String name){
        if(obj==null){
            obj = new LazySingletonLicence(name);
        }
        return obj;
    }
    public void getLicence(){
        System.out.println("Licence issued for "+this.name);
    }
}

public class LazySingleton {
    public static void main(String[] args) {
        LazySingletonLicence l1 = LazySingletonLicence.getInstance("Ansh");
        LazySingletonLicence l2 = LazySingletonLicence.getInstance("Rahul");
        l1.getLicence();
        l2.getLicence();
    }
}
