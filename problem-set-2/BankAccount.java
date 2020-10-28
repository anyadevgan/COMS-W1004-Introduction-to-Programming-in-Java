//****************************************
//
//  BankAccount.java
//
//  This class models a bank account.
//
//  by Anya Devgan
//  UNI: ad3706
//  Date: Feb 13, 2020
//
//*****************************************



public class BankAccount {

    //instance variables
    public double balance;
    private String name;
    private long acctNumber;
    
    //constructor
    public BankAccount(String initName, long acct)
    {
        name=initName;
        acctNumber=acct;
        balance=0.0;
    }

    //methods
    public void deposit(double amt)
    {
        balance=balance+amt;
    }

    public void withdraw(double amt)
    {
        balance=balance-amt;
    }
    
    public double getBalance()
    {
        return balance;
    }

} //end of the class
