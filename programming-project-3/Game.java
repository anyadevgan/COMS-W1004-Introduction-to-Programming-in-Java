/*****************************************
 * Game.java
 * Part of the Nim game.
 * Anya Devgan
 * UNI: ad3706
 ****************************************/

import java.lang.Math;

public class Game{
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private int difficultyLevel;
    
    //determine the level automatically
    public Game(){
        difficultyLevel = (int) (Math.random() * 2 + 1);
        marbles = (int)(Math.random() * 91 + 10);
        humanPlayer = new Human();
        computerPlayer = new Computer(difficultyLevel);
    }
    
    //specify the level of game 
    public Game(int level){
        difficultyLevel = level;
        marbles = (int)(Math.random() * 91 + 10);
        humanPlayer = new Human();
        computerPlayer = new Computer(difficultyLevel);
    }
    
    //this method models the playing of the game itself.
    public void play(){
        //decide who takes the first turn
        int firstTurn = (int)(Math.random() * 2);
        
        //print number of marbles in pile
        System.out.println("There are " + marbles + " marbles in the pile");
        
        //executes the moves of the Nim game
        gameOutline(firstTurn);
 
    }
    
    //moves and result of Nim game modeled
    private void gameOutline(int turn){
        //assuming player goes first
        if(turn == 0){
            System.out.println("Player goes first");
            
            while(marbles > 0){
                humanMove(marbles); //human makes a move
                
                if(marbles > 0){
                    computerMove(marbles);
                    //if computer takes last marble, it loses
                    if(marbles == 0){
                        System.out.println("You win!");
                    }
                }
                //if human takes last marble, they lose
                else if(marbles == 0){
                    System.out.println("You lose!");
                }
            }
        }
        //assuming computer goes first
        else{
            System.out.println("Computer goes first");
            
            while(marbles > 0){
                computerMove(marbles); //computer makes a move
                
                if(marbles > 0){
                    humanMove(marbles);
                    //if human takes last marble, they lose
                    if(marbles == 0){
                        System.out.println("You lose!"); 
                    }
                }
                //if computer takes last marble, it loses
                else if(marbles == 0){
                    System.out.println("You win!"); 
                }
            }
        }
    }
    
    //this method models the computer making a move
    private void computerMove(int marLeft){
        //computer player decids how many marbles to take
        computerPlayer.move(marLeft);
        
        //decided number of marbles are removed from the pile
        marbles = marbles - computerPlayer.getChoice();
        System.out.println("There are " + marbles + 
                           " marbles left in the pile");
    }
    
    //this method models the human player making a move
    private void humanMove(int marLeft){
        //human player decides how many marbles to take
        humanPlayer.move(marLeft);
        
        // decided number of marbles are removed from the pile
        marbles = marbles - humanPlayer.getChoice();
        System.out.println("There are " + marbles + 
                           " marbles left in the pile");
    }

}