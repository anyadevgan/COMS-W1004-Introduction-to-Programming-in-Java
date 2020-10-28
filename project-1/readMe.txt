That is, write in plain English, simple instructions for using your software,
explanations for how and why you chose to design your code the way you did
and any other classmates you may have discussed your work with.

Problem 2.
In order to create a program that converts the number of days, weeks,
and years into hours, I wrote the Hours.java class with the following
logic:
    1. Create a scanner that takes in input from the user.
    2. Use the scanner to prompt the user for number of days, weeks, and
    years, and store the values as ints.
    3. Declare the variable "hours" of type int. Initialize this variable,
    assigning it a value equal the corresponding number of hours.
    4. Print out the number of hours calculated.
    
Problem 3.
In order to create a program that determines the date of Easter Sunday
on a given year, I wrote the Easter.java class with the following logic:
    1. Create a scanner that takes in input from the user.
    2. Use the scanner to prompt the user for a year and store the value
    as an int.
    3. Following Fredich Gauss' algorithm for determining the date of
    Easter Sunday on a given year, declare and initialize variables of type
    int. The use of this algorithm assumes that the year inputted is after
    1582.
    4. Use a series of if statements to compare the value of the "month" 
    variable to the month that year's Easter Sunday falls on. If the value
    of month equals 1, then the month must be January. If the condition in
    the if statement is satisfied, print a statement including the year 
    and month Easter Sunday fell on in that year. Extend this logic to
    all months through to December.
    
Problem 4.
In order to create a program that determines if a year is a leap year,
I wrote a class with the following logic:
    1. Declare a private instance variable of type int called year. This 
    variable's scope is for the entire class Year.java
    2. Write a constructor. The LeapYearTester class calls on this 
    constructor when creating a new instance of the class. The constructor
    sets the instance variable year to the parameter provided, y.
    3. Write the isLeapYear method that has a boolean return type. Use an
    if statement to check whether the year meets all criteria for a leap
    year. If the year is divisible by 4 and not divisible by 100, but 
    divisible by 400, then return true. If the year does not meet this 
    criteria then return false.