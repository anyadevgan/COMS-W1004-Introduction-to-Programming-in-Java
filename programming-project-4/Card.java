//*********************************
//Card.java
//This class models a card
//Anya Devgan
//UNI: ad3706
//*********************************

public class Card implements Comparable<Card>{
	
	private int suit; //use integers 1-4 to encode the suit
	private int rank; //use integers 1-13 to encode the rank
	
    //constructs a Card
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
        rank = r;
	}
	
    //this method compares cards so they can be sorted
    //compares card by rank and then suit (ranked alphabetically) 
	public int compareTo(Card c){
		int value = 0;
        
        if(this.rank < c.rank){
            value = -1;
        }
        else if(this.rank == c.rank){
            if(this.suit < c.suit){
                value = -1;
            }
            else if(this.suit == c.suit){
                value = 0;
            }
            else if(this.suit > c.suit){
                value = 1;
            }
        }
        else{
            value = 1;
        }

        return value;
	}
	
    //this method prints a Card object
	public String toString(){
		String nameOfCard = "";
        
        if(rank == 1){
            nameOfCard = "Ace of ";
        }
        else if(rank == 11){
            nameOfCard = "Jack of ";
        }
        else if(rank == 12){
            nameOfCard = "Queen of ";
        }
        else if(rank == 13){
            nameOfCard = "King of ";
        }
        else{
            nameOfCard = Integer.toString(rank) + " of ";
        }
        
        if(suit == 1){
            nameOfCard += "Clubs";
        }
        if(suit == 2){
            nameOfCard += "Diamonds";
        }
        if(suit == 3){
            nameOfCard += "Hearts";
        }
        if(suit == 4){
            nameOfCard += "Spades";
        }
        
        return nameOfCard;
	}
    
    public int getValue(){
        return rank;
    }
    
    public int getSuit(){
        return suit;
    }

}
