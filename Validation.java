//********************************************************************* 
//*                                                                   * 
//*   CIS611             Spring 2018 Luis Castro and  Rocco Meconi    * 
//*                                                                   * 
//*                      Program Assignment PP02                      * 
//*                                                                   * 
//*                      Class Description                            *
//*                      Class for checking validity of input credit  *
//*                      Cards and return of boolean value
//*                      Date Created    02/24/18                     * 
//*                                                                   * 
//*                      Saved in: Validation.java                    * 
//*                                                                   * 
//*********************************************************************

package PP2;

import javax.swing.JOptionPane;

public class Validation {
	//static String test = "4388576018402626";
  // Return true if the card number is valid, otherwise returns false, this method is already implemented
  public boolean aValidNumber(String n) {
	
	long number = Long.parseLong(n);
	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
  }// end of aValidNumber method  
  
  //get the sum of even places numbers, Starting from the second digit from right  
  private int totalEevenNumbers(long number) {
	  int result = 0;
	  int doubleResult = 0;
	 
      while (number > 0) {
    	  // remove rightmost digit
    	  number /= 10;
    	  //call method on the current rightmost digit *2 and store result
          doubleResult = singleDigit((int) (number %10) * 2);
          //add the result to the total
          result += doubleResult;	
          //remove the digit we just added
          number /= 10;
      }
      //System.out.println("Even Total Result " + result);
      return result;

}

// Return the same number if it is a single digit, otherwise, return the sum of
  // the two digits in this number
  private int singleDigit(int number) {
	  int Value = 0;
	  if (number <= 9) {
            Value = number;
            
        } else {
            int firstDigit = number % 10;
            int secondDigit = (int) (number / 10);
            Value = firstDigit + secondDigit;
        }
	  return Value;
  } // end of singleDigit method

 
 // Return the sum of odd place digits in number
  private int totalOddNumbers(long number) {
	int result = 0;
	  
    while (number > 0) {

        int digit = (int) (number % 10);
        digit = singleDigit(digit);
        result += digit;
        number /= 100;
    }
    //System.out.println("Odd Result " + result);
      return result;


  }// end of totalOddNumbers method

  // Return true if the digit d is a prefix for number
  private boolean prefixCheck(long number, int d) {
	  	long digits = 0;
	  	boolean x = false;
	  	digits = numPrefix(number, d);
	  	//System.out.println(digits);
	  	if (digits == 37 || digits == 4 || digits == 5 || digits == 6){
	  		x = true;
	  	}
	  	//System.out.println(x);
		return x;
	
  }// end of prefixCheck method


  // Return the number of digits in this number parameter
  private int numLength(long number) {

	  int result = 0;
	  String strLong = Long.toString(number);
	  result = strLong.length();   
	     
	  return result;
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  // Depending on the card type
  private long numPrefix(long number, int k) {
	  String strLong = Long.toString(number);
	  long result = 0;
	  result = strLong.length();
	  	  if (result == 13){
	  		  number = number / 1000000000000L;
	  		  //System.out.println("13 " + number);
	  		  k = (int) number;
	  	  } else  if (result == 14){
	  		  number = number / 10000000000000L;
	  		  //System.out.println("14 " + number);
	  		  k = (int) number;
	  	  } else  if (result == 15){
	  		  number = number / 10000000000000L;
	  		  //System.out.println("15 " + number);
	  		  k = (int) number;
	  	  } else  if (result == 16){
	  		  number = number / 1000000000000000L;
	  		  //System.out.println("16 " + number);
	  		  k = (int) number;
	  	  }  else {
	  		JOptionPane.showMessageDialog(null,  "Invalid Input Cards must be be between 13-16 digits long -  Exit program");
			System.exit(0);
	  	  }
	   
	  //System.out.println("Prefix Returned is " + k);
	  
	return k;
  }// end of numPrefix method

}// end of the class
