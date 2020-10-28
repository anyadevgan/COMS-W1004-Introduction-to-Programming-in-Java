//****************************************
//
//  CircuitTester.java
//
//  This class tests a circuit controlling 
//  a hallway light.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 17, 2020
//
//*****************************************


public class CircuitTester{
    public static void main(String[] args){
        
        Circuit myCircuit = new Circuit();
        
        //0,0,0 then toggle first switch to 1,0,1
        myCircuit.toggleFirstSwitch();
        int switchState1 = myCircuit.getFirstSwitchState();
        int switchState2 = myCircuit.getSecondSwitchState();
        int lampState = myCircuit.getLampState();
        System.out.println("EXPECTED: first switch state=1, second switch state=0, lamp state=1");
        System.out.println("ACTUAL: first swich state=" + switchState1 + " , second switch state=" 
                           + switchState2 + " , lamp state=" + lampState);
        
        //1,0,1 then toggle second switch to 1,1,0
        myCircuit.toggleSecondSwitch();
        switchState1 = myCircuit.getFirstSwitchState();
        switchState2 = myCircuit.getSecondSwitchState();
        lampState = myCircuit.getLampState();
        System.out.println("EXPECTED: first switch state=1, second switch state=1, lamp state=0");
        System.out.println("ACTUAL: first swich state=" + switchState1 + " , second switch state=" 
                           + switchState2 + " , lamp state=" + lampState);
        
        //1,1,0 then toggle first switch again to 0,1,1
        myCircuit.toggleFirstSwitch();
        switchState1 = myCircuit.getFirstSwitchState();
        switchState2 = myCircuit.getSecondSwitchState();
        lampState = myCircuit.getLampState();
        System.out.println("EXPECTED: first switch state=0, second switch state=1, lamp state=1");
        System.out.println("ACTUAL: first swich state=" + switchState1 + " , second switch state=" 
                           + switchState2 + " , lamp state=" + lampState);
        
        //0,1,1 then toggle second switch again to 0,0,0
        myCircuit.toggleSecondSwitch();
        switchState1 = myCircuit.getFirstSwitchState();
        switchState2 = myCircuit.getSecondSwitchState();
        lampState = myCircuit.getLampState();
        System.out.println("EXPECTED: first switch state=0, second switch state=0, lamp state=0");
        System.out.println("ACTUAL: first swich state=" + switchState1 + " , second switch state=" 
                           + switchState2 + " , lamp state=" + lampState);

        
    }
    
}