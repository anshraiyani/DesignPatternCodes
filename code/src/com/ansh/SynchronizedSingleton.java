package com.ansh;

class SynchronizedSingletonLicence{
    public static SynchronizedSingletonLicence obj;
    private String name;
    private SynchronizedSingletonLicence(String name){
        this.name=name;
    }
    public static synchronized SynchronizedSingletonLicence getInstance(String name){
        if(obj==null){
            obj = new SynchronizedSingletonLicence(name);
        }
        return obj;
    }
    public void getLicence(){
        System.out.println("Licence issued for "+this.name);
    }
}

public class SynchronizedSingleton {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedSingletonLicence l1 = SynchronizedSingletonLicence.getInstance("Ansh");
                l1.getLicence();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedSingletonLicence l2 = SynchronizedSingletonLicence.getInstance("Rahul");
                l2.getLicence();
            }
        });

        t1.start();
        t2.start();
    }
}
