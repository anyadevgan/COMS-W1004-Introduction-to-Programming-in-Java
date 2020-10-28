//****************************************
//
//  Car.java
//
//  This class models a circuit controlling
//  a hallway light.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

public class Car{
    
    //instance variables
    private double fuelEfficiency; // units: miles/gallon
    private double fuelLevel;
      
    //constructor
    public Car(double fuelEff)
    {
        fuelEfficiency = fuelEff;
        fuelLevel = 0;
    }
    
    //methods
    public void drive(double distance) //distance units: miles
    {
        fuelLevel = fuelLevel - (distance*(1/fuelEfficiency));
    }
    
    public double getGasInTank()
    {
        return fuelLevel;
    }
    
    public void addGas(double fuelInput)
    {
        fuelLevel = fuelLevel + fuelInput;
    }
    
    
}