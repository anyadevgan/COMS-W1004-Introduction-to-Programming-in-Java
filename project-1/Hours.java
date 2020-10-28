/**
 * 
 * Hours.java
 * This program converts a number of days, weeks, and 
 * years into hours.
 * 
 * Written by Anya Devgan
 * UNI: ad3706
 * Date: February 6th, 2020
 * 
 */

import java.util.Scanner;

public class Hours{
    
    public static void main(String[] args){
        
        //create scanner
        Scanner sc = new Scanner(System.in);
        
        //get input
        System.out.println("Enter a number of days: ");
        int days = sc.nextInt();
        System.out.println("Enter a number of weeks: ");
        int weeks = sc.nextInt();
        System.out.println("Enter a number of years: ");
        int years = sc.nextInt();
        
        //calculate number of hours
        int hours = (24*days) + (7*24*weeks) + (365*24*years);
        
        //print number of hours
        System.out.println(years + " years and " + weeks + " weeks and "
                           + days + " days is equivalent to " + hours + " hours.");
        
    }
}
 
