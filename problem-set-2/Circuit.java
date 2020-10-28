//****************************************
//
//  Circuit.java
//
//  This class models a circuit controlling
//  a hallway light.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 17, 2020
//
//*****************************************

public class Circuit{
    
    //instance variables
    private int switchState1;
    private int switchState2;
    private int lampState;
    
    //constructor
    public Circuit()
    {
        switchState1 = 0; 
        switchState2 = 0; 
        lampState = 0;
    }
    
    //methods
    public int getFirstSwitchState()
    {
        return switchState1;
    }
        
    public int getSecondSwitchState()
    {
        return switchState2;
    }
        
    public int getLampState()
    {
        if((switchState1+switchState2)%2==0)
        {
           lampState=0; 
        }
        else
            lampState=1;
        return lampState;
    }
      
    public void toggleFirstSwitch()
    {
        if(switchState1==0)
        {
            switchState1=1;
        }
        else
        {
            switchState1=0; 
        }
    }
        
    public void toggleSecondSwitch()
    {
        if(switchState2==0)
        {
            switchState2=1;
        }
        else
        {
            switchState2=0;
        }
    }
}