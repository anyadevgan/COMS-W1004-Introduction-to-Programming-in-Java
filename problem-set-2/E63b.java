//****************************************
//
//  E63b.java
//
//  This class prints every second letter of
//  an inputted string.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 15, 2020
//
//*****************************************

import java.util.Scanner;
import java.util.*;

public class E63b{
    public static void main(String[] args){
                
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        //print every second letter of the string
        if(input.length()<2)
        {
            System.out.print("invalid input");
        }
        else
        {
            for(int i=1; i<input.length(); i+=2)
            {
                System.out.print(input.charAt(i));
            } 
        }
        
    }
}