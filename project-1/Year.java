/**
*
* Year.java
* This class represents a calendar year. It contains 
* a method that determines if the year is a leap year.
* 
* Written by Anya Devgan
* UNI: ad3706
* Date: February 7th, 2020
*
*/

public class Year{
    
    // declare your instance variables here
    private int year;


    // write your constructor here
    public Year(int y){
        year = y;
    }

    
    public boolean isLeapYear(){
        if((year%4 == 0 && year%100 != 0) || (year%400 == 0)){
            return true;
        }
        else{
            return false;
        }
    }

}    

