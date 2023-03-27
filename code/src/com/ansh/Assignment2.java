package com.ansh;

class Licence{
    private String driverName;
    private int age;
    private String vehicalNo;
    private int licenceNo;

    public Licence(String driverName, int age, String vehicalNo, int licenceNo) {
        this.driverName = driverName;
        this.age = age;
        this.vehicalNo = vehicalNo;
        this.licenceNo = licenceNo;
    }

    @Override
    public String toString() { //overriding toString method to get a well defined output
        return "Licence{" +
                "driverName='" + driverName + '\'' +
                ", age=" + age +
                ", vehicalNo='" + vehicalNo + '\'' +
                ", licenceNo=" + licenceNo +
                '}';
    }
}

class LicenceBuilder{ //this class includes appropriate setters and getters to set desired values and get a new phone object.
    private String driverName;
    private int age;
    private String vehicalNo;
    private int licenceNo;

    public LicenceBuilder setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public LicenceBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public LicenceBuilder setVehicalNo(String vehicalNo) {
        this.vehicalNo = vehicalNo;
        return this;
    }

    public LicenceBuilder setLicenceNo(int licenceNo) {
        this.licenceNo = licenceNo;
        return this;
    }

    public Licence getLicence(){
        return new Licence(driverName,age,vehicalNo,licenceNo);
    }

}

public class Assignment2 {
    public static void main(String[] args) {
        Licence l1 = new LicenceBuilder().setDriverName("Ansh").setAge(19).setVehicalNo("GJ-06-2003").setLicenceNo(172).getLicence();
        System.out.println(l1);
    }
}
