/*****************************************
 * Zipcode.java
 * Generates a barcode for a zipcode and vice versa.
 * Anya Devgan
 * UNI: ad3706
 ****************************************/ 

public class Zipcode{
    
    private int zipcode;
    private String barcode;
    
    //constants created for readability
    private final String ONE = ":::||";
    private final String TWO = "::|:|";
    private final String THREE = "::||:";
    private final String FOUR = ":|::|";
    private final String FIVE = ":|:|:";
    private final String SIX = ":||::";
    private final String SEVEN = "|:::|";
    private final String EIGHT = "|::|:";
    private final String NINE = "|:|::";
    private final String ZERO = "||:::";
    
    //takes in int input to construct a Zipcode
    public Zipcode(int zip){
        zipcode = zip;
    }
    
    //takes in a String input to construct a Zipcode
    public Zipcode(String bar){
        barcode = bar;
    }
    
    //returns corresponding barcode to ZIP code
    public String getBarcode(){
        return assembleBarcode();

    }
    
    //this method converts individual digit into the corresponding bar code
    private String convertDigit(int digit){
        String digitString = "";
        
        if(digit == 1){
            digitString = ONE;
        }
        else if(digit == 2){
            digitString = TWO;
        }
        else if(digit == 3){
            digitString = THREE;
        }
        else if(digit == 4){
            digitString = FOUR;
        }
        else if(digit == 5){
            digitString = FIVE;
        }
        else if(digit == 6){
            digitString = SIX;
        }
        else if(digit == 7){
            digitString = SEVEN;
        }
        else if(digit == 8){
            digitString = EIGHT;
        }
        else if(digit == 9){
            digitString = NINE;
        }
        else if(digit == 0){
            digitString = ZERO;
        }
        
        return digitString;
    }

    //this method assembles the barcode
    private String assembleBarcode(){
        
        //adds zeros to the front of the ZIP code
        String zip_str = Integer.toString(zipcode);
        int len = zip_str.length();
        
        if(len < 5){
            while(len != 5){
                zip_str = "0" + zip_str;
                len++;
            }
        } 
        
        //adds frame bars and check code to the barcode
        String zipString = zip_str;
        
        barcode = "|" + convertZip(zipString) + getCheck(zipString) + "|";
        
        return barcode; 
    }
    
    //this method returns the zipcode's converted barcode without the check
    //digit and intial and final bars.
    private String convertZip(String zipString){
        String digitString = "";
        
        for(int k = 0; k < 5; k++){
            digitString += convertDigit(
                Integer.parseInt(zipString.substring(k,k+1)));
        }
        
        return digitString;
    }

    //this method returns the check digit for the barcode
    private String getCheck(String zipString){
        int sum = 0;
        int checkDigit = 0;

        for(int i = 0; i < 5; i++){
            sum += Integer.parseInt(zipString.substring(i,i+1));
        }
        
        while((sum + checkDigit) % 10 != 0)
        {
            checkDigit++;
        }
        
        return convertDigit(checkDigit);
        
    } 
    
    //REVERSE. Convert zip code to barcode
    
    //returns corresponding ZIP code to barcode
    public String getZIPcode(){
        return assembleZipcode();
        
    }
    
    //this method assembles the ZIP code
    private String assembleZipcode(){
        String temp = "";
        String zip_to_return = "";
        
        for(int i = 1; i < 26; i+=5){
            temp += convertCode(i);
        }
        
        zipcode = Integer.parseInt(temp);
        zip_to_return = String.format("%05d", zipcode);    
        
        //returns zipcode depending on if zipcode is valid
        if(checkBarcode(zip_to_return) == false){
            System.out.println("Given barcode is invalid due to invalid "
                               + "check digit.");
            zip_to_return = "-1";

        }
        
        return zip_to_return;
        
    }
    
    //this method checks if the user enters a valid barcode
    private boolean checkBarcode(String barcode_check){
        String temp = "";
        boolean valid = true;
        int sum = 0;
        
        for(int i = 1; i < 31; i+=5){
            temp += convertCode(i);
        }
        
        for(int count = 0; count < 6; count++){
            int digit = Integer.parseInt(temp.substring(count, count + 1));
            sum += digit;
        }
        
        if(sum % 10 != 0){
            valid = false;            
        }

        return valid;
        
    }
    
    //this method returns the corresponding digit to the given part 
    //of the barcode
    private String convertCode(int index){
        String codeDigit = "";
        
        if(barcode.substring(index, index+5).equals(ONE)){
            codeDigit = "1";
        }
        else if(barcode.substring(index, index+5).equals(TWO)){
            codeDigit = "2";
        }
        else if(barcode.substring(index, index+5).equals(THREE)){
            codeDigit = "3";
        }
        else if(barcode.substring(index, index+5).equals(FOUR)){
            codeDigit = "4";
        }
        else if(barcode.substring(index, index+5).equals(FIVE)){
            codeDigit = "5";
        }
        else if(barcode.substring(index, index+5).equals(SIX)){
            codeDigit = "6";
        }
        else if(barcode.substring(index, index+5).equals(SEVEN)){
            codeDigit = "7";
        }
        else if(barcode.substring(index, index+5).equals(EIGHT)){
            codeDigit = "8";
        }
        else if(barcode.substring(index, index+5).equals(NINE)){
            codeDigit = "9";
        }
        else if(barcode.substring(index, index+5).equals(ZERO)){
            codeDigit = "0";
        }
        
        return codeDigit;
        
    }
    
    
}