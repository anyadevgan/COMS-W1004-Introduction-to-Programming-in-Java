Problem 1. Nim Game
In order to create a program that models the Nim game, I wrote the Game.java,
Computer.java, and Human.java classes to work within the tester Nim.java 
class. The following logic was used:
    
    Nim.java
        1. Tester (unchanged)
    
    Game.java
        1. Two constructors were created. One constructor is to be used if 
        the level is determined automatically. One structure is to be used 
        if the user specifies the difficulty level of the game.
        
        2. The method play() was written, modeling the playing of the game
        itself. First, who is going to take the first turn is determined and
        the number of marbles in the pile are printed. Then, the method
        calls gameOutline().
        
        3. gameOutline() takes in a parameter of type int and models the 
        moves and result of the game. It maps out the scenarios depending on
        which player is to go first. Which ever player ends up taking the 
        last marble loses. This method calls the computerMove() and 
        humanMove() methods.
        
        4. computerMove() takes in a parameter of type int and models the 
        computer making a move. This method calls methods from the 
        Computer.java class such as move() and getChoice().
        
        5. humanMove() takes in a parameter of type int and models the human
        player making a move. This method calls methods from the Human.java 
        class such as move() and getChoice().
    
    Computer.java
        1. The constructor initializes an object of the Computer class that 
        has mode m (specified) and choice = -1.
        
        2. The method move() takes a parameter of type int, detailing the 
        choices the computer will make depending on how many marbles are left 
        in the pile. The computer will take however many marbles necessary to
        get to a number that satisfies 2^n - 1. If it is already at this 
        number then the computer takes a random number of marbles.
        
        3. getChoice() is an accessor method that returns the value of choice.
    
    Human.java
        1. The constructor initializes an object of the Human class that has
        choice = -1 and input of type Scanner.
        
        2. The move() method takes a parameter of type int and details the
        choices the human player will make depending on how many marbles are 
        left. If the pile has more than one marble, then the player will be
        prompted to input the number of marbles they want to take. As long as
        the player takes at least one but not more than half of the marbles,
        the choice is considered valid. If the user takes the last marble, 
        then the human loses.
        
        3. The getChoice() method is an accessor method that returns the value
        of the instance variable choice.
        
        
        
Problem 2. ZIPcode and Barcode
In order to write a program that converts a zipcode into its corresponding 
barcode and a barcode into its corresponding zipcode, I wrote the Zipcode.java
class that works within the ZipTest.java class. I used the following logic:
    
    ZipTest.java
        1. Tester (unchanged)
    
    Zipcode.java
        1. The instance variable zipcode of type int was created. The instance
        variable barcode of type String was created. Additionally, constants 
        representing the barcode for each digit were created for readability.
        
        2. Two constructors were created (overloading). The first constructor
        takes in a parameter of type int when the tester class asks the user
        to input a zipcode. The second constructor takes in a parameter of 
        type String when the tester class asks the user to input a barcode.
        
        3. The method getBarcode() calls the method assembleBarcode() and 
        returns the barcode.
        
        4. The method assembleBarcode() relies on subsequent methods to 
        assemble the various components of the barcode. The method also adds 
        zeros to the front of the zipcode if the user gives a zipcode with 
        leading zeros.
        
        5. The method convertZip() takes in a parameter of type String. This 
        method returns the zipcode's converted barcode without the check digit
        and initial and final frame bars.
        
        6. The method getCheck() takes in a parameter of type String. It 
        returns  the check digit for the barcode. The method first finds the
        total of all the numbers in the zipcode and figures out what check digit
        is required to make the sum evenly divisible by 10. Then the method  
        converts the check digit of type int into its corresponding barcode 
        which is a String.
       
        7. The method convertDigit() takes in a parameter of type int. It 
        converts an individual digit into its corresponding barcode, relying
        on a series of if-else if statements.
        
        8. Moving on to the conversion of a barcode into a zipcode, the method
        getZipcode() calls the method assembleZipcode() and returns the zipcode.
        This method also calls the checkBarcode() method to see if the barcode 
        is valid and has the correct check code. 
        
        9. The checkBarcode() method takes in a parameter of type String. This
        method checks if the user enters a valid barcode. If the user enters a 
        barcode with the wrong check code, then this method will identify that. 
        The method assumes that the user will enter a barcode with proper frame
        bars and is of length 32 (5 digits + 1 check digit + 2 frame bars). This 
        method will return true or false depending on if the barcode is valid or
        not.
        
        10. The method convertCode() takes in a parameter of type int. The 
        method returns the corresponding digit to the given part of the barcode. 
        The method uses the substring method to check parts of the inputted 
        barcode, assigning each segment of five (not including the frame bars) 
        a corresponding digit. 
