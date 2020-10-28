/* Anya Devgan
 * ad3706
 * CreditCard.java
 * This class represents a card number as a String. It contains methods
 * that check if a credit card is valid or not.
 */

public class CreditCard{
    
    //instance variables
    private String input;
    private boolean valid;
    private int errorCode;
    
    //constructor
    public CreditCard(String in)
    {
        input = in;
        valid = true;
        errorCode = 0;
    }
    
    //This method checks if the first digit is a 4 and returns
    //the value of valid.
    private boolean check1()
    {
        if(input.charAt(0) != '4')
        {
            valid = false;
        }
        
        return valid;
    }
    
    //This method checks if the fourth digit is one greater
    //than the fifth digit and returns the value of valid.
    private boolean check2()
    {
        if((Integer.parseInt(input.substring(3,4))) -
           (Integer.parseInt(input.substring(5,6))) != 1)
        {
            valid = false;
        }
        
        return valid;
    }
    
    //This method checks if the product of the first, fifth, 
    //and ninth digits is 24 and returns the value of valid.
    private boolean check3()
    {
        if((Integer.parseInt(input.substring(0,1))) *
           (Integer.parseInt(input.substring(5,6))) *
           (Integer.parseInt(input.substring(10,11))) != 24)
        {
            valid = false;
        }
        
        return valid;
    }
    
    //This method checks if the sum of all digits is evenly divisible
    //divisible by 4 and returns the value of valid.
    private boolean check4()
    {
        if(((Integer.parseInt(input.substring(0,1))) +
            (Integer.parseInt(input.substring(1,2))) +
            (Integer.parseInt(input.substring(2,3))) +
            (Integer.parseInt(input.substring(3,4))) +
            (Integer.parseInt(input.substring(5,6))) +
            (Integer.parseInt(input.substring(6,7))) +
            (Integer.parseInt(input.substring(7,8))) +
            (Integer.parseInt(input.substring(8,9))) +
            (Integer.parseInt(input.substring(10,11))) +
            (Integer.parseInt(input.substring(11,12))) +
            (Integer.parseInt(input.substring(12,13))) +
            (Integer.parseInt(input.substring(13,14)))) % 4 != 0)
        {
            valid = false;
        }
        
        return valid;
    }
    
    //This method checks if the sum of the first four digits
    //is one less than the sum of the last four digits and
    //returns the value of valid.
    private boolean check5()
    {
        if(((Integer.parseInt(input.substring(10,11))) +
            (Integer.parseInt(input.substring(11,12))) +
            (Integer.parseInt(input.substring(12,13))) +
            (Integer.parseInt(input.substring(13,14)))) -
           ((Integer.parseInt(input.substring(0,1))) +
            (Integer.parseInt(input.substring(1,2))) +
            (Integer.parseInt(input.substring(2,3))) +
            (Integer.parseInt(input.substring(3,4)))) != 1)
        {
            valid = false;
        }
        
        return valid;
    }

    //This method checks treats the first two digits as a two-digit
    //number and the seventh and eighth two digits as a two-digit number. 
    //It checks if the sum of these two-digit numbers is 100 and returns
    //the value of valid.
    private boolean check6()
    {
        if(Integer.parseInt(input.substring(0,2)) +
           Integer.parseInt(input.substring(7,9)) != 100)
        {
            valid = false;
        }
        
        return valid;
    }
    
    //This public method calls the four support methods to check to
    //see if the number is valid.
    public void check()
    {
        if(check1() == false)
        {
            errorCode = 1;
        }
        else if(check2() == false)
        {
            errorCode = 2;
        }
        else if(check3() == false)
        {
            errorCode = 3;
        }
        else if(check4() == false)
        {
            errorCode = 4;
        }
        else if(check5() == false)
        {
            errorCode = 5;
        }
        else if(check6() == false)
        {
            errorCode = 6;
        }
    }
    
    //This method is an accessor method for the instance variable valid.
    public boolean isValid()
    {
        return valid;
    }
    
    //This method is an accessor method for the instance variable errorCode.
    public int getErrorCode()
    {
        return errorCode;
    }
    
}