/*****************************************
 * Computer.java
 * Represents computer player in Nim game.
 * Anya Devgan
 * UNI: ad3706
 ****************************************/ 

public class Computer{
    private int mode;
    private int choice;
    
    //constructor
    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
    //this method helps the computer make a move
    public void move(int marblesLeft){
        if(marblesLeft == 1){
            choice = (int)(Math.random()*(marblesLeft/2)+1);
        }
        else{
            if(marblesLeft == 1 || marblesLeft == 3 || marblesLeft == 7 || 
               marblesLeft == 15 || marblesLeft == 31 || marblesLeft == 63){
                choice = (int)(Math.random()*(marblesLeft/2)+1);
            }
            else{
                if(marblesLeft > 63){
                    choice = marblesLeft - 63;
                }
                else if(marblesLeft > 31){
                    choice = marblesLeft - 31;
                }
                else if(marblesLeft > 15){
                    choice = marblesLeft - 15;
                }
                else if(marblesLeft > 7){
                    choice = marblesLeft - 7;
                }
                else if(marblesLeft > 3){
                    choice = marblesLeft - 3;
                }
                else{
                    choice = marblesLeft - 1;
                }  
            }
        }
    }
    
    //this method is an accessor method for the instance variable choice
    public int getChoice(){
        return choice;
    }
    
    
}
