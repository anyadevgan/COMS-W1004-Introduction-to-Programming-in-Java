//****************************************
//
//  CarTester.java
//
//  This class tests the Car.java class.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

public class CarTester{
    public static void main(String[] args){
        
        Car myHybrid = new Car(50); //50 miles per gallon
        myHybrid.addGas(20); //Tank 20 gallons
        myHybrid.drive(100); //Drive 100 miles
        double gasLeft = myHybrid.getGasInTank(); //Get gas remaining in tank
        System.out.println("Expected amount of gas left: 18 gallons"); //20-(100/50)=18 gallons
        System.out.println("Remaining amount of gas left: " + gasLeft + " gallons");
        
    }
}