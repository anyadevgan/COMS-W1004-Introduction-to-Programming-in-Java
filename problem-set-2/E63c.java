//****************************************
//
//  E63c.java
//
//  This class prints the string, with all
//  vowels replaced by an underscore.
//  
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

import java.util.*;
import java.util.Scanner;

public class E63c{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        //print the string with all vowels replaced 
        //by an underscore
        for(int i=0; i<input.length(); i++)
        {
            if(input.substring(i,i+1).equals("a") || 
               input.substring(i,i+1).equals("e") || 
               input.substring(i,i+1).equals("i") || 
               input.substring(i,i+1).equals("o") || 
               input.substring(i,i+1).equals("u"))
                System.out.print("_");
            else
                System.out.print(input.substring(i,i+1));
                    
                
        }
    }
}
