package com.ansh.decorator;

// License interface
interface License {
    public void issueLicense();
}

// decorator class for additional functionalities
abstract class LicenceDecorator implements License{
    protected License decoratedLicence;

    public LicenceDecorator(License decoratorLicence){
        this.decoratedLicence =decoratorLicence;
    }

    public void issueLicence(){
        decoratedLicence.issueLicense();
    }
}

// concrete class for two wheeler vehicle
class TwoWheelerVehicleLicence implements License{
    @Override
    public void issueLicense() {
        System.out.println("two wheeler licence issued");
    }
}

// concrete class for four wheeler vehicle
class FourWheelerVehicleLicence implements License{
    @Override
    public void issueLicense() {
        System.out.println("two wheeler licence issued");
    }
}

// concrete class for additional functionalities
class IssueRCdecorator extends LicenceDecorator{

    public IssueRCdecorator(License decoratedLicence){
        super(decoratedLicence);
    }

    @Override
    public void issueLicense() {
        decoratedLicence.issueLicense();
        issueRC(decoratedLicence);
    }

    private void issueRC(License decoratedLicence){
        System.out.println("RC issued");
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        License l = new TwoWheelerVehicleLicence();
        License RC_l1 = new IssueRCdecorator(new TwoWheelerVehicleLicence());
        License RC_l2 = new IssueRCdecorator((new FourWheelerVehicleLicence()));

        System.out.println("Regular two wheeler licence");
        l.issueLicense();
        System.out.println("");

        System.out.println("Two wheeler licence with RC");
        RC_l1.issueLicense();
        System.out.println("");

        System.out.println("Four wheeler licence with RC");
        RC_l2.issueLicense();
    }
}