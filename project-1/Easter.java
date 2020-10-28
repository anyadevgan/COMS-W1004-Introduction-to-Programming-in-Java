/**
 * 
 * Easter.java
 * This program implements the algorithm created by Fredich
 * Gauss for determining the date of Easter Sunday.
 * 
 * Written by Anya Devgan
 * UNI: ad3706
 * Date: February 6th, 2020
 * 
 */

import java.util.Scanner;

public class Easter{
  
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year:");
        int year = sc.nextInt();

        //calculate the day and month of Easter Sunday in this year
        int a = year%19;
        int b = year/100;
        int c = year%100;
        int d = b/4;
        int e = b%4;
        int g = (8*b+13)/25;
        int h = (19*a+b-d-g+15)%30;
        int j = c/4;
        int k = c%4;
        int m = (a+11*h)/319;
        int r = (2*e+2*j-k-h+m+32)%7;
        int month = (h-m+r+90)/25;
        int day = (h-m+r+month+19)%32;
        
        //check values for corresponding day and month
        if(month == 1){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on January " + day + ".");
        }
        if(month == 2){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on February " + day + ".");    
        }
        if(month == 3){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on March " + day + ".");
        }
        if(month == 4){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on April " + day + ".");    
        }
        if(month == 5){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on May " + day + ".");
        }
        if(month == 6){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on June " + day + ".");   
        }
        if(month == 7){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on July " + day + ".");
        }
        if(month == 8){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on August " + day + ".");    
        }
        if(month == 9){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on September " + day + ".");    
        }
        if(month == 10){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on October " + day + ".");    
        }
        if(month == 11){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on November " + day + ".");
        }
        if(month == 12){
            System.out.println("In " + year + 
                               ", Easter Sunday fell on December " + day + ".");    
        }     

    }

}	
