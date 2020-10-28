//****************************************
//
//  E63e.java
//
//  This class prints the uppercase letters
//  of a string.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

import java.util.Scanner;
import java.util.*;

public class E63e{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        //print the positions of all vowels in the string
        //assumes that the first letter in the string has an index of 0.
        for(int i=0; i<input.length(); i++)
        {
            if(input.substring(i,i+1).equals("a") || 
               input.substring(i,i+1).equals("e") || 
               input.substring(i,i+1).equals("i") || 
               input.substring(i,i+1).equals("o") || 
               input.substring(i,i+1).equals("u"))
            {
                System.out.print(i + " ");
            }
        }
    }
}