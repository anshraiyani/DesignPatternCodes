    package com.ansh;

    class EagerSingletonLicence{
        private static final EagerSingletonLicence obj = new EagerSingletonLicence();
        private EagerSingletonLicence(){
            System.out.println("Licence Issued");
        }
        public static EagerSingletonLicence getInstance(){
            return obj;
        }
        public void issueLicence(){
        }
    }

    public class EagerSingleton {
        public static void main(String[] args) {
            EagerSingletonLicence l1 = EagerSingletonLicence.getInstance();
            EagerSingletonLicence l2 = EagerSingletonLicence.getInstance();
//            l1.issueLicence();
//            l2.issueLicence();
        }
    }
