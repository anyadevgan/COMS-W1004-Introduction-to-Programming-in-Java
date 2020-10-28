//*********************************
//Deck.java
//This class models a deck of cards
//Anya Devgan
//UNI: ad3706
//*********************************

public class Deck {
	
	private Card[] cards;
	private int top; //the index of the top of the deck
	
	public Deck(){
		//make a 52 card deck here
		cards = new Card[52];
        int count = 0;
        
        for(int s = 1; s < 5; s++){ //suit
            for(int r = 1; r < 14; r++){ //rank
                Card temp = new Card(s,r);
                cards[count] = temp;
                count++;
            }  
        }
        
        top = 0;
        
	}
	
    //shuffles the deck and sets top to zero
	public void shuffle(){
        Card temp = new Card(1,1); //put random arguments
        int random1 = 0;
        int random2 = 0;
        
        //exchange two cards with index between 0 and 51 in a loop 
        //for one hundred times
        for(int i = 0; i < cards.length; i++){
            random1 = (int)(Math.random()*52);
            random2 = (int)(Math.random()*52);
            temp = cards[random1];
            cards[random1] = cards[random2];
            cards[random2] = temp;
        }
        top = 0;
    }
	
    //deals top card in the deck
    //increments top so return next card for next time
	public Card deal(){
        if(top > 51){
            shuffle(); //sets top to zero
        }
        top++;
        
        return cards[top-1];
	}
		
    //to test the shuffle method
    public String toString(){
        String output = "";
        for(Card element : cards){
            output += element + " ";
        }
        return output;
    }

}
