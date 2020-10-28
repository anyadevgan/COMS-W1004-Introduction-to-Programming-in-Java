In order to create a program that checks whether a credit card 
number is valid or not, I wrote the CreditCard.java class with
the following logic:
1. Declare the following private instance variables: input of type
String, valid of type boolean, and errorCode of type int. The scope 
of these variables is for the entire class CreditCard.java

2. Write a constructor. The CreditCardTester class calls on this
constructor when creating a new instance of the class. The constructor
sets the instance variable input to the parameter provided, in. The
constructor also sets valid to true and errorCode to zero. The instance
variable valid is set to true so that it can later be set to false 
if the check method reveals that the credit card number does
not achieve the six checksum criteria provided. errorCode was set to zero
due to specifications in the problem's instructions.

3. Write the check1 method that has a boolean return type. Use an if 
statement to check whether the credit card's first digit is 4. However,
remember that the credit card number is assigned to the instance variable
input which is of type String. Therefore, the if statement must rely
on the charAt() method and not treat the first digit in the credit card
number as an int. The method returns true if the first number is 4. 
If it is not, the method returns false.

4. Write the check2 method that has a boolean return type. Use an if
statement to check whether the fourth digit is one greater than the 
fifth digit. Since the condition within the if statement uses mathematical
operators for integers, the digits from the credit card number must be 
converted from a string integer into a primitive type integer using the
parseInt method. The method returns true if the fourth digit is one 
greater than the fifth. If not, it returns false.

5. Write the check3 method that has a boolean return type. Use an if 
statement to check whether the product of the first, fifth, and ninth
digits is 24. Once again, the needed string integers are converted into
primitive integers and used within the condition of the if statement. 
The method returns true if the product of these digits is 24. If not,
it returns false.

6. Write the check4 method that has a boolean return type. Use an if
statement to check whether the sum of all the digits in the credit card
number is evenly divisble by 4. Here, the parseInt method is used in 
conjunction with the modulus operator. The method returns true if the
digits of the credit card number are divisible by 4. If not, it returns
false.

7. Write the check5 method that has a boolean return type. Use an if 
statement to check whether the sum of the first four digits is one
less than the sum of the last four digits. The parseInt method is used 
to convert the digits into primitive integers and the substring method 
is used to extract the sets of four digits themselves. The method returns 
true if the sum of the first four digits is one less than the sum of the 
last four. If not, returns false.

8. Write the check6 method that has a boolean return type. The substring
method is used to extract the first two and last two digits from the 
credit card number that is assigned to a instance variable of type String.
Treat these as two-digit numbers. Use an if statement to check whether the
sum of the first two-digit numbers and last two-digit numbers is 100. 
Once again, the parseInt method is used to convert the String integers into
primitive integers. The method returns true if the sum of these two numbers
is 100. If not, returns false.

9. Write the check method that has no return type. Use a series of if-
else if statements to check if the credit card number is valid and, if
it is not, which of the six checksum criteria the credit card number is first to
contradict. The first if statement checks if the method check1 returns false
(i.e. if the first digit is not 4); if the condition within the if statement
is met and the first digit is not 4, then the errorCode is assigned a value 
of 1. If the first checksum is satisfied, then the second condition within
the subsequent else if statement is checked. Depending on which conditions 
are satisfied and which checksum the inputted credit card number first breaks, 
then a related errorCode number will be assigned through this method.

10. Write the isValid method that has a boolean return type. Return the
value of the instance variable valid. This instance variable will either
be assigned a value of true or false. This is an accessor method.

11. Write the getErrorCode method that has a int return type. Return the
value of the instance variable errorCode. This is an accessor method for the
errorCode instance variable of type int.