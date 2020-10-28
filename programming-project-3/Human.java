/*****************************************
 * Human.java
 * Represents human player in Nim game.
 * Anya Devgan
 * UNI: ad3706
 ****************************************/ 
import java.util.Scanner;

public class Human{
   
    private int choice;
    private Scanner input;
    
    //constructor
    public Human(){
        input=new Scanner(System.in);
        choice = -1;
    }
    
    //this method lets the player make a move if it is valid
    public void move(int marblesLeft){
        boolean valid = false;
        
        while(valid == false){
            System.out.println("How many marbles do you want to take?");
            choice = input.nextInt();
            
            if((marblesLeft == 1) && (choice == 1)){
                valid = true;
            }
            else if((choice > 0) && (choice <= marblesLeft/2)){
                valid = true;
            }
            else{
                System.out.println("That is not a valid choice. Try again.");
            }
        }
       
    }
    
    //this method returns how many marbles that human player takes
    public int getChoice(){
        return choice;
    }
    
    
}
