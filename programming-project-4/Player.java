//*****************************************
//Player.java
//This class models a player for the game
//Anya Devgan
//UNI: ad3706
//*****************************************

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private ArrayList<Card> hand; //the player's cards
	private double bankroll;
    private double bet;

    //create a player here
	public Player(){		
	    bankroll = 100; //every player starts with 100 tokens 
        bet = 0;
        hand = new ArrayList<Card>();
	}

	//add the card c to the player's hand
    public void addCard(Card c){
        hand.add(c);
    }

    //remove the card c from the player's hand
	public void removeCard(Card c){
	    hand.remove(c);
    }
    	
    //player makes a bet
    public void bets(double amt){
        bankroll -= amt;
        bet = amt;
    }

    //adjust bankroll if player wins
    public void winnings(double odds){
        bankroll += odds;
    }

    //return current balance of bankroll
    public double getBankroll(){
        return bankroll;
    }
    
    //convert hand into readable format
    public String handToString(){
        String handAsString = "| ";
        
        for(Card element : hand){
            handAsString += element.toString() + " | ";
        }
        
        return handAsString;
    }
    
    //returns hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //sorts hand
    public void sort(){
        Collections.sort(hand);
    }
    
    //get hand length
    public int handLength(){
        return hand.size();
    }
    
    //resets hand
    public void resetHand(){
        hand.clear();
    }
    
    //gets card at specified position
    public Card getCard(int pos){
        return hand.get(pos);
    }
    
}


