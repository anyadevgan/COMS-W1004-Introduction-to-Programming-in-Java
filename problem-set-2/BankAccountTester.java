//****************************************
//
//  BankAccount.java
//
//  This class tests the BankAccount.java 
//  class.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 13, 2020
//
//*****************************************

import java.util.Scanner;

public class BankAccountTester{
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of your bank account:");
        String name = input.nextLine();
        //assume the user inputs a valid bank account number
        System.out.println("Enter your bank account number:");
        long accountNum = input.nextLong();
        
        BankAccount myBankAccount = new BankAccount(name, accountNum);
        
        //deposit $1,000 in bank account
        myBankAccount.deposit(1000);
        
        //withdraw $500 from bank account
        myBankAccount.withdraw(500);
        
        //withdraw $400 from bank account
        myBankAccount.withdraw(400);
        
        //print remaining balance
        System.out.println("Expected bank account balance: $100."); //1000-500-400=100
        System.out.println("Remaining bank account balance: $" + myBankAccount.getBalance());
          
    }
}