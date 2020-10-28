//****************************************
//
//  E63d.java
//
//  This class prints the number of vowels
//  in the string.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

import java.util.*;
import java.util.Scanner;

public class E63d{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        int count = 0;
        
        //count the number of vowels in the string
        for(int i=0; i<input.length(); i++)
        {
            if(input.substring(i,i+1).equals("a") || 
               input.substring(i,i+1).equals("e") || 
               input.substring(i,i+1).equals("i") || 
               input.substring(i,i+1).equals("o") || 
               input.substring(i,i+1).equals("u"))
            {
                count++;
            }
        }
        
        //print the number of vowels in the string
        System.out.println("There are " + count + 
                           " vowels in the string");
    }
}