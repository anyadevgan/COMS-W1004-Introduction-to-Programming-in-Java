//*********************************
//Game.java
//This class models a game of poker
//Anya Devgan
//UNI: ad3706
//*********************************

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Game {
	
	private Player p;
	private Deck cards;
    private Scanner sc = new Scanner(System.in);
    private double bet;
	
	
	public Game(String[] testHand){
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
        p = new Player();
        cards = new Deck();
        bet = 0;
		
		for(String element : testHand){
            p.addCard(convertToCard(element));
        }
        
        cards.shuffle();
	}
    
	
    // This no-argument constructor is to actually play a normal game
	public Game(){
        cards = new Deck();
        p = new Player();
        bet = 0;
        
        cards.shuffle();
        
        //give player a hand of 5 cards to start with
        for(int i = 0; i < 5; i++){
            p.addCard(cards.deal());
        }
        
	}
	
    //this method should play the game
	public void play(){
        System.out.println("Welcome to video poker!");

        boolean continueGame = true; //allows game to loop
        
        //place a bet
        System.out.println("Your balance: " + p.getBankroll() + " tokens.");
        
        while(continueGame && p.getBankroll() > 0){
            //player places a bet
            makeBet();
            p.bets(bet);
            
            //player sees hand and replaces unwanted cards
            replaceCard();
            
            //reveal to player hand after replacement of cards
            System.out.println("This is your new hand: " + p.handToString());
            
            //declare hand type
            System.out.println("The result is " + checkHand(p.getHand()));
            
            //shows payout and new bankroll amount
            double payOut = getPayOut(checkHand(p.getHand())) * bet;
            System.out.println("Payout: " + (int)payOut + " tokens.");
            p.winnings(payOut);
            System.out.println("Your score is now: " + (int)p.getBankroll());
            
            //asks if the player wants to play again
            System.out.println("Would you like to play again? " + 
                           "Type 'Y' for yes or 'N' for no.");
            continueGame = replay(sc.nextLine());     
        }
        
	}
	
    //evaluates the hand and returns it as a String
	public String checkHand(ArrayList<Card> hand){
  
		//sort the hand
		p.sort();
        
        //evaluate the hand
        if(royalFlush(hand)){
            return "Royal flush";
		}
        else if(straightFlush(hand)){
            return "Straight flush";
        }
        else if(fourOfAKind(hand)){
            return "Four of a kind";
        }
        else if(fullHouse(hand)){
            return "Full house";
        }
        else if(flush(hand)){
            return "Flush";
        }
        else if(straight(hand)){ 
            return "Straight";
        }
        else if(threeOfAKind(hand)){
            return "Three of a kind";
        }
        else if(twoPair(hand)){
            return "Two pair";
        }
        else if(onePair(hand)){ 
            return "One pair";
        }
        else{
            return "No pair";
        }
		
	}
	
    public boolean royalFlush(ArrayList<Card> hand){
        boolean isRoyalFlush = false;
        
        if(royalty(hand) && flush(hand)){
            isRoyalFlush = true;;
        }
        
        return isRoyalFlush;
    }
    
    public boolean straightFlush(ArrayList<Card> hand){
        boolean isStraightFlush = false;
        
        if(straight(hand) && flush(hand)){
            isStraightFlush = true;
        }
        return isStraightFlush;
    }
    
    public boolean fourOfAKind(ArrayList<Card> hand){
        boolean isFourKind = false;
        
        for(int index = 0; index < hand.size() - 3; index++){
            if(hand.get(index).getValue() == hand.get(index+3).getValue()){
                isFourKind = true;
            }
        }
        
        return isFourKind;
    }
    
    public boolean fullHouse(ArrayList<Card> hand){
        boolean isFullHouse = false;
        
        if(firstCheck(hand) || secondCheck(hand)){
            isFullHouse = true;
        }
        
        return isFullHouse;
    }
    
    public boolean flush(ArrayList<Card> hand){
        boolean isFlush = true;
        
        for(int index = 0; index < hand.size()-1; index++){
            if(hand.get(index).getSuit() != hand.get(index+1).getSuit()){
                isFlush = false;
            }
        }
        
        return isFlush;
    }

    public boolean straight(ArrayList<Card> hand){
        int counter = 0;
        
        for(int i = 1; i < hand.size(); i++){
            if(hand.get(i).getValue() == hand.get(i-1).getValue() + 1){
                counter++;
            }
        }
        if(counter == 4){
            return true;
        }
        else{
            return royalty(hand);
        }

    }
    
    public boolean threeOfAKind(ArrayList<Card> hand){
        boolean isThreeKind = false;
        
        for(int index = 0; index < hand.size() - 2; index++){
            if(hand.get(index).getValue() == hand.get(index+1).getValue() && 
               hand.get(index).getValue() == hand.get(index+2).getValue()){
                isThreeKind = true;
            }
        }
        
        return isThreeKind;
        
    }
    
    public boolean twoPair(ArrayList<Card> hand){
        boolean isTwoPair = false;
        int index = 0;
        
        //finds first pair starting at index 0
        for(int j = 0; j < hand.size() - 1; j++){
            if(hand.get(j).getValue() == hand.get(j + 1).getValue()){
                break;
            }
            index++;
        }
        
        //finds second pair starting after indexes of first pair
        for(int index2 = index + 2; index2 < hand.size() - 1; index2++){
            if(hand.get(index2).getValue() == hand.get(index2 + 1).getValue()){
                isTwoPair = true;
            }
        }
        
        return isTwoPair;
    }
    
    public boolean onePair(ArrayList<Card> hand){
        boolean isPair = false;
        for(int i = 0; i < hand.size() - 1; i++){
            if(hand.get(i).getValue() == hand.get(i+1).getValue()){
                isPair = true;
            }
        }
        return isPair;
    }

    //asks which cards to replace and replaces them
    public void replaceCard(){
        
        System.out.println("Here is your hand: " + p.handToString());
        
        System.out.println("Would you like to replace any cards?" 
                           + " Enter 'Y' for yes or 'N' for no.");
        String choice = sc.nextLine();
        
        if(choice.equals("Y")){
            System.out.println("Which cards would you like to replace?");
            System.out.println("Ex. Type '1234' to replace the first, " 
                               + " second, third, and fourth cards.");
            String replaceString = sc.nextLine();
            char[] replaceArray = replaceString.toCharArray();
            
            for(int i = 0; i < replaceArray.length; i++){
                String substitute = Character.toString(replaceArray[i]);
                p.removeCard(p.getCard(Integer.parseInt(substitute)-1-i));
                p.addCard(cards.deal());
            }
            
        }
        else{
            System.out.println("Assuming no cards are to be replaced.");
        }
       
    }
    
    //allows a player to make a bet
    public void makeBet(){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        
        while(valid == false){
            System.out.print("Please place a bet between 1 and 5 tokens: ");
            bet = input.nextDouble();
            
            if(bet > p.getBankroll()){
                System.out.println("You don't have enough tokens. Try again.");
            }
            else if(bet >= 1 && bet <= 5 && bet <= p.getBankroll()){
                valid = true;
            }
            else{
                System.out.println("Not valid. Please try again.");
            }
        }
    }
    
    //checks if the player wants to play again
    public boolean replay(String input){
        boolean playAgain;
        
        if(input.equals("N")){
            playAgain = false;
            System.out.println("Thank you for playing!");
        }
        else if(input.equals("Y") && p.getBankroll() > 0){
            playAgain = true;
            
            p.resetHand();
            
            for(int i = 0; i < 5; i++){
                p.addCard(cards.deal());
            }
        }
        else if(input.equals("Y") && p.getBankroll() <= 0){
            System.out.println("Sorry! You are out of tokens. Ending game.");
            playAgain = false;
        }
        else{
            System.out.println("Error. Ending game.");
            playAgain = false;
        }
        
        return playAgain;  
    }
    
    //Checks if the hand is a straight where the ace is the high card.
    //This method evaluates the hand considering the value of ace as 
    //14 rather than its default value of 1. 
    //e.g. Ace, King, Queen, Jack, 10 indicates a "royalty".
    public boolean royalty(ArrayList<Card> hand){
        boolean isRoyalty = false;
        int count = 0;
        
        //check if last four cards are consecutive in rank
        for(int i = 2; i < hand.size(); i++){
            if(hand.get(i).getValue() == hand.get(i-1).getValue() + 1){
                count++;
            }
        }
        
        //check if the first card is an ace and the last is a king.
        if(count == 3){
            if(hand.get(0).getValue() == 1 && 
               hand.get(hand.size()-1).getValue() == 13){
                isRoyalty = true;
            }
        }
        
        return isRoyalty;
        
    }
    
    //converts elements from args to Card types
    public Card convertToCard(String c){
        int suit = 0;
        int rank = 0;
        
        //suit
        if(c.substring(0,1).equals("c")){
            suit = 1;
        }
        else if(c.substring(0,1).equals("d")){
            suit = 2;
        }
        else if(c.substring(0,1).equals("h")){
            suit = 3;
        }
        else if(c.substring(0,1).equals("s")){
            suit = 4;
        }
        
        //rank
        if(c.length()==2){
            rank=Integer.parseInt(c.substring(1,2));
        }
        else if(c.length()==3){
            rank=Integer.parseInt(c.substring(1,3));
        }
        
        Card temp = new Card(suit,rank);
        return temp;
    }
    
    //used in fullHouse() method
    //checks if the first two cards in the hand are a pair and if
    //the last three cards in the hand are three of a kind. This is
    //one of the possible combinations that leads to a full house.
    public boolean firstCheck(ArrayList<Card> hand){
        ArrayList<Card> part1 = new ArrayList<Card>();
        ArrayList<Card> part2 = new ArrayList<Card>();
        boolean check = true;
        
        //first two cards
        for(int i = 0; i < 2; i++){
            part1.add(hand.get(i));
        }
        
        //last three cards
        for(int j = 2; j < 5; j++){
            part2.add(hand.get(j));
        }
        
        //checks part1 to see if the cards are of the same rank.
        //this would indicate that the first two cards are a pair
        //if not achieved, return false.
        if(part1.get(0).getValue() != part1.get(1).getValue()){
            check = false;
        }
     
        //checks part2 to see if the three cards are of the same rank.
        //this would indicate that the last three cards are 3 of a kind.
        //if not achieved, return false.
        for(int k = 0; k < part2.size() - 1; k++){
            if(part2.get(k).getValue() != part2.get(k+1).getValue()){
                check = false;
            }
        }
        
        return check; 
    }
    
    //counterpart to firstCheck() method and is also used in fullHouse()
    //this check offers the second possibility for a full house: the 
    //first three cards are three of a kind and the last two are a pair.
    public boolean secondCheck(ArrayList<Card> hand){
        ArrayList<Card> part1 = new ArrayList<Card>();
        ArrayList<Card> part2 = new ArrayList<Card>();
        boolean check = true;
        
        //first three cards
        for(int i = 0; i < 3; i++){
            part1.add(hand.get(i));
        }
        
        //last two cards
        for(int j = 3; j < 5; j++){
            part2.add(hand.get(j));
        }
        
        //checks part1 to see if the three cards are of the same rank.
        //this would indicate that the first three cards are 3 of a kind.
        //if not achieved, return false.
        for(int k = 0; k < part1.size() - 1; k++){
            if(part1.get(k).getValue() != part1.get(k+1).getValue()){
                check = false;
            }
        }
        
        //checks part2 to see if the two cards are of the same rank.
        //this would indicate that the last two cards are a pair.
        //if not achieved, return false.
        if(part2.get(0).getValue() != part2.get(1).getValue()){
            check = false;
        }
        
        return check;
    }
    
    //helps calculate overall payout amount by returning the related
    //multiplier for a evaluated hand.
    public int getPayOut(String evaluatedHand){
        
        if(evaluatedHand == "Royal flush"){
            return 250;
        }
        else if(evaluatedHand == "Straight flush"){
            return 50;
        }
        else if(evaluatedHand == "4 of a kind"){
            return 25;
        }
        else if(evaluatedHand == "Full house"){
            return 6;
        }
        else if(evaluatedHand == "Flush"){
            return 5;
        }
        else if(evaluatedHand == "Straight"){
            return 4;
        }
        else if(evaluatedHand == "Three of a kind"){
            return 3;
        }
        else if(evaluatedHand == "Two pair"){
            return 2;
        }
        else if(evaluatedHand == "One pair"){
            return 1;
        }
        else{
            return 0;
        }

    }
	
}
