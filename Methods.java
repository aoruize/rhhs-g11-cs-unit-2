import java.util.Scanner;
import java.lang.Math;

/* Methods.java
 * This program calculates the hypotenuse of a right-angle triangle
 * @author Matthew Ao
 * March 1, 2019
 */

public class Methods{
  /* *** main method *** */
  public static void main(String[] args){ 
    
    Scanner input = new Scanner(System.in);
    
    /* Exercise 1
    System.out.println("Exercise 1 - Calculating the hypotenuse of a triangle");
    System.out.println("Enter first side:");
    double a = input.nextDouble();
    System.out.println("Enter second side:");
    double b = input.nextDouble();
    double c = hypotenuse(a, b);
    System.out.println("The hypotenuse is " + c);
    */
    
    /* Exercise 2
    System.out.println("Exercise 2 - Calculating length and slope of a line");
    System.out.println("Enter x1 and y1: ");
    double x1 = input.nextDouble(), y1 = input.nextDouble();
    System.out.println("Enter x2 and y2: ");
    double x2 = input.nextDouble(), y2 = input.nextDouble();
    double lineSlope = slope(x1, y1, x2, y2);
    double lineLength = hypotenuse((x2-x1),(y2-y1));
    System.out.println("The slope of the line is " + lineSlope + " and the length of the line is " + lineLength);
    */
    
    /* Exercise 3
    System.out.println("Exercise 3 - Calculating the number of roots in a quadratic");
    System.out.println("Value of a: ");
    double a_3 = input.nextDouble();
    System.out.println("Value of b: ");
    double b_3 = input.nextDouble();
    System.out.println("Value of c: ");
    double c_3 = input.nextDouble();
    String numRoots = numRoots(a_3, b_3, c_3);
    if(numRoots != 1){
      System.out.println("There are " + numRoots + " in the quadratic.");
    }else{
      System.out.println("There is " + numRoots + " in the quadratic.");
    }
    */
    
    /* exercise 4
    System.out.println("Exercise 4 - Finding the GCF of two numbers");
    System.out.println("Number 1: ");
    long num1_4 = input.nextLong();
    System.out.println("Number 2: ");
    long num2_4 = input.nextLong();
    long gcf = gcf(num1_4, num2_4);
    System.out.println("The GCF is " + gcf + ".");
    */
    
    /* exercise 5
    System.out.println("Exercise 5 - Calculating the factorial of a number.");
    System.out.println("Enter a number: ");
    int num_5 = input.nextInt();
    long factorial = factorial(num_5);
    System.out.println("The factorial of " + num_5 + " is " + factorial + ".");
    */
    
    /* exercise 6
    System.out.println("Exercise 6 - Outputting a sentence in reverse order.");
    System.out.println("Enter a sentence: ");
    String sentence_6 = input.nextLine();
    String reversed = reverse(sentence_6);
    System.out.println(reversed);
    */
    
    /* exercise 7 
    System.out.println("Exercise 7 - Outputting a binary number as an integer.");
    System.out.println("Enter a binary number: ");
    String inputBinary;
    int int_7 = 0;
    do{
      inputBinary = input.next(); // user inputs binary number
      int_7 = binaryToInt(inputBinary);
    }while(int_7 == -1);
    System.out.println("The binary number " + inputBinary + " is " + int_7 + ".");
    */
    
    /* exercise 8
    System.out.println("Exercise 8 - Outputting an integer as a binary number.");
    System.out.println("Enter an integer: ");
    int int_8 = input.nextInt();
    String binary_8 = intToBinary(int_8);
    System.out.println("The integer " + int_8 + " is " + binary_8 + " in binary.");
    */
    
    /* exercise 9 
    System.out.println("Exercise 9 - Outputting the sum of two binary numbers.");
    String binary1_9; int int1_9;
    String binary2_9; int int2_9;
    String binarySum;
    System.out.println("Enter a binary number: ");
    do{
      binary1_9 = input.next(); 
      int1_9 = binaryToInt(binary1_9);
      System.out.println(int1_9);
    }while(int1_9 == -1);
    System.out.println("Enter another binary number: ");
    do{
      binary2_9 = input.next();
      int2_9 = binaryToInt(binary2_9);
      System.out.println(int2_9);
    }while(int2_9 == -1);
    binarySum = binarySum(int1_9, int2_9);
    int binaryIntSum = binaryToInt(binarySum);
    System.out.println("The sum of the two binary numbers is " + binarySum + ",\nwhich is equivalent to " + binaryIntSum);
    */
    
    /* challenge exercise */
    System.out.println("Challenge Exercise - Outputting the reversed sum of two reversed numbers");
    System.out.println("Enter a number: ");
    int challengeNum1 = input.nextInt();
    System.out.println("Enter a number: ");
    int challengeNum2 = input.nextInt();
    int reversedSum = reversedSum(challengeNum1, challengeNum2);
    System.out.println("The reversed sum of both numbers reversed is " + reversedSum + ".");
    
    // close scanner
    input.close();
  }
  
  /**
   * hypotenuse
   * Find the hypotenuse given the two leg lengths
   * @param a A double that describes the length of the first leg
   * @param b A double that describes the length of the second leg
   * @return A double that describes the length of the hypotenuse
   **/
  public static double hypotenuse(double a, double b){
    double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    return c;
  }
  
  /**
   * slope 
   * Find the slope given the endpoint coordinates of a line
   * @param x1 The x-coordinate of the first point
   * @param y1 The y-coordinate of the first point
   * @param x2 The x-coordinate of the second point
   * @param y2 The y-coordinate of the second point
   * @return A double that describes the slope of the line
   **/
  public static double slope(double x1, double y1, double x2, double y2){
    double slope = (y2 - y1)/(x2 - x1);
    return slope;
  }
  
  /**
   * numRoots
   * Find the number of roots given the a, b, c values of a quadratic 
   * @param a A double that describes the a value of a quadratic
   * @param b A double that describes the b value of a quadratic
   * @param c A double that describes the c value of a quadratic
   * @return A string that describes the number of roots
   **/
  public static String numRoots(double a, double b, double c){
    double discriminant = Math.pow(b, 2) - 4*a*c;
    if(discriminant > 0){
      return "2 real roots";
    }else if(discriminant == 0){
      return "1 real root";
    }else{
      return "2 imaginary roots";
    }
  }
  
  /**
   * gcf
   * Find the greatest common factor given the value of two numbers
   * @param num1 A long that describes the value of the first number
   * @param num2 A long that describes the value of the second number
   * @return A long that describes the value of the two numbers' greatest common factor 
   **/
  public static long gcf(long num1, long num2){
    long diff = num2 - num1;
    if(num2 < num1){
      diff = num1 - num2;
    }else if(num1 == num2){
      diff = num1;
    }
    long gcf = 1;
    for(long i = 1; i <= diff; i++){
      if(num1 % i == 0 && num2 % i == 0){
        gcf = i;
        System.out.println(i);
      }
    }
    return gcf;
  }
  
  /** 
   * factorial
   * Finds the factorial given a number
   * @param num An int describing the value of the number
   * @return An int describing the value of the number's factorial
   **/
  public static int factorial(int num){
    for(int i = num-1; i > 0; i--){
      num *= i;
      System.out.println(num);
    }
    return num;
  }
  
  /** 
   * funFactorial
   * Finds the factorial given a number
   * @param num An int describing the value of the number
   * @return An int describing the value of the number's factorial
   */
  public static int funFactorial (int num) {
    if (num == 1) {
      return 1;
    }
    return num * funFactorial (num - 1);
  }
  
  /**
   * reverse
   * Reverses the words in a sentence
   * @param original A string that contains the sentence to be reversed
   * @return A string that contains the reversed sentence
   **/
  public static String reverse(String original){
    // split the sentence into words based on the number of 
    String[] originalWords = original.split(" ");
    String reversedSentence = "";
    for(int i = originalWords.length-1; i >= 0; i--){
      reversedSentence += originalWords[i] + " ";
    }
    return reversedSentence;
  }
  
  /**
   * binaryToInt
   * Converts a binary string to an integer
   * @param binary A string that contains a binary number
   * @return The integer equal to the value of the inputted binary number
   * or a value of -1 if the string contains an invalid binary number
   **/
  public static int binaryToInt(String binary){
    // declaring integer value that is equivalent to binary
    int binaryLength = binary.length();
    int intValue = 0;
    // checking if binary number is valid
    for(int i = 0; i < binaryLength; i++){ 
      if(binary.substring(i, i+1).equals("1")){
        intValue += Math.pow(2, binaryLength-i-1); 
      }else if(!(binary.substring(i, i+1).equals("0"))){
        System.out.println("Please enter a valid binary number."); // if invalid, reenter binary number
        return -1;
      }
    }
    return intValue;
  }
  
  /**
   * intToBinary
   * Converts an integer to its binary value in string form
   * @param integer An int value that contains the integer to be converted into binary form
   * @return A string that contains the binary number converted from the integer
   **/
  public static String intToBinary(int integer){
    String binary = "";
    int counter = 0;
    long firstValue = 0;
    long[] powersOfTwo = new long[20];
    // appending powers of 2 to array
    for(int i = 0; i < 20; i++){
      powersOfTwo[i] = Math.round(Math.pow(2, i));
    }  
    // determining the largest power of 2 that fits into the integer
    do{
      counter += 1;
      firstValue = powersOfTwo[counter];
    }while(firstValue + powersOfTwo[counter] <= integer);
    /* subtract the largest power of 2 that fits into the integer, then every subsequent smaller power of 2 that fits
    and build the binary number by concatenating 1 to the string for every power that fits into the integer
    and 0 for every power that doesn't*/
    for(int i = counter; i >= 0; i--){
      if(integer - Math.pow(2, i) >= 0){
        integer -= Math.pow(2, i);
        binary += "1";
      }else{
        binary += "0";
      }
    }
    
    System.out.println(binary);
    
    return binary;
  }
  
  /**
   * binarySum
   * Finds the sum of two numbers and outputs it in binary
   * @param num1 An int that describes the value of the first number
   * @param num2 An int that describes the value of the second number
   * @return A string containing the sum of the two numbers in binary 
   **/
  public static String binarySum(int num1, int num2){
    int intSum = num1 + num2;
    String binarySum = intToBinary(intSum);
    return binarySum;
  }
  
  /**
   * numDigits
   * finds the number of digits in an integer
   * @param num describes the integer of integer
   * @return the number of digits in the integer
   **/
  public static int numDigits(int num){
    int counter = 0;
    int digits = 0;
    boolean running = true;
    // counting number of digits
    do{
      digits += 1;
    }while(num/(Math.pow(10, digits)) >= 1);

    return digits;
  }
  
  /**
   * reverseInt
   * Reverses an integer number
   * @param num An int describing the value of the number
   * @return The reversed integer number
   **/
  public static int reverseInt(int num){
    int reversed = 0;
    // find number of digits in num
    int numDigits = numDigits(num);
    // reverse digits 
    for(int i=0; i<= numDigits; i++){
      reversed += (Math.floor((num%Math.pow(10,i))/Math.pow(10,i-1)))*Math.pow(10, numDigits-i);
    }
    return reversed;
  }
  
  public static int reversedSum(int a, int b){
    int result = 0;

    // reversing digits in both ints
    a = reverseInt(a);
    b = reverseInt(b);
    System.out.println("The first number reversed is " + a + " and the second number reversed is " + b + ".");
    
    // reversing the sum of reversed ints
    result = reverseInt(a+b);
    return result;
  }
}