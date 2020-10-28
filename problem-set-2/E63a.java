//****************************************
//
//  E63a.java
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

public class E63a{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        //print the uppercase letters in the string
        for(int i=0; i<input.length(); i++)
        {
            
            if(input.substring(i,i+1).equals(input.substring(i,i+1).toUpperCase()))
            {
                System.out.print(input.substring(i,i+1)+ " ");
            }
        }
        
    }
}