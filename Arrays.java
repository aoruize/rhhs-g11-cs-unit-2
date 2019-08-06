/* Arrays.java
 * This program contains array exercises
 * @author Matthew Ao
 * @version 1.0.0
 */

import java.util.Scanner;

class Arrays{
  public static void main(String[] args){
    // initiating scanner
    Scanner input = new Scanner(System.in);
    
    /*** exercise 1 
    int[] num10 = new int[10];
    System.out.println(Exercise 1 - Operations with 10 numbers);
    
    // storing numbers in an array of length 10
    for (int i = 0; i < 10; i++){
      System.out.println("Store a number in the array: ");
      num10[i] = input.nextInt();
    }
    
    // reversing array
    int[] reverseNum10 = reverseNums(num10);
    System.out.print("The reversed array is {");
    for (int i = 0; i<10; i++){
      System.out.print(" " + reverseNum10[i] + " ");
    }
    System.out.print("}. ");
    
    // outputting array's average
    int averageNum10 = averageNums(num10);
    System.out.println("The average of the numbers in the array is " + averageNum10 + ".");
    
    // outputting smallest number in array
    int minNum10 = minNums(num10);
    System.out.println("The smallest number in the array is " + minNum10 + ".");
    */
    
    /*** exercise 2 ***
    System.out.println("Exercise 2 - Guess Secret Words");
    // requesting array of secret words from user
    String[] secretWords = new String[3];
    for(int i=0; i<3; i++){
      System.out.println("Enter the "+(i+1)+"th"+" secret word.");
      secretWords[i] = input.next();
    }
    System.out.println("Let the game begin.");
    // initializing array of correctly guessed words
    String[] correctWords = {"", "", ""};
    do{
      System.out.println("Guess a word: ");
      String guess = input.next();
      correctWords = matchWord(secretWords, correctWords, guess);
    }while(correctWords[2].length() == 0);
    System.out.println("\nCongratulations, you have guessed all three words.");
    */
    
    /*** Exercise 3 - Find Prime Numbers ***/
    System.out.println("Exercise 3 - Finding Primes");
    // requesting array from user
    System.out.println("How many numbers are in your array?"); // requesting length of array
    int length3 = input.nextInt();
    int[] nums3 = new int[length3]; // initializing array
    for(int i=0; i<length3; i++){
      System.out.println("Enter the "+(i+1)+"th number: "); // requesting numbers to add to array
      nums3[i] = input.nextInt();
    }
    // print array to screen
    System.out.print("\nYour array is {");
    for(int i=0; i<length3; i++){
      System.out.print(" "+i+" "); // print every element in nums3 array
    }
    System.out.println("}");
    // call findPrimes function
    int[] primes3 = findPrimes(nums3);
    // print array of prime numbers to screen
    System.out.print("\nThe prime numbers in your array are {");
    for(int i=0; i<primes3.length; i++){
      System.out.print(primes3[i]); // print every element in primes3 array
    }
    System.out.println("}");
      
    
    /*** closing scanner ***/
    input.close();
  }
  
  /**
   * reverseNums
   * reverses the numbers in an int[] array
   * @param nums an array of ints 
   * @return a new array containing the ints from the original nums array in reversed order
   **/
  public static int[] reverseNums(int[] nums){
    int[] reverse = new int[nums.length];
    for (int i=0; i<nums.length; i++){
      reverse[i] = nums[nums.length-i-1];
    }
    return reverse;
  }
  
  /**
   * averageNums
   * finds the average of the numbers in an int[] array
   * @param nums an array of ints
   * @return the average of the ints in the nums array
   **/
  public static int averageNums(int[] nums){
    int average = 0;
    for (int i=0; i<10; i++){
      average+= nums[i];
    }
    average /= nums.length;
    return average;
  }
  
  /**
   * minNums
   * Finds the smallest number in an int[] array
   * @param nums An int[] array containing numbers
   * @return The smallest number in the array
   **/
  public static int minNums(int[] nums){
    int min = nums[0];
    for (int i = 0; i<nums.length; i++){
      if (min > nums[i]){
        min = nums[i];
      }else{
      }
    }
    return min;
  }
  
  /**
   * matchWord
   * Finds if a guessed word matches any words in an array. If there is a match, the word is added to an array containing correct guesses.
   * @param array A String[] array containing words
   * @param correctGuesses A String[] array containing correct guesses
   * @param guessedWord A String containing the guessed word
   * @return The correctGuesses array
   **/
  public static String[] matchWord(String[] array, String[] correctGuesses, String guessedWord){
    // loop through array to check if guess equals any secret words in array
    for(int i=0; i<array.length; i++){
      if(guessedWord.equals(array[i])){
        // if the guessed word is equal to any of the secret words
        // then we will add it to an array of correct guesses. If the guessed word matches any String in the array of words, the guessed word will be added to this array.
        for(int j=0; j<correctGuesses.length; j++){
          if(correctGuesses[j].length() == 0){
            correctGuesses[j] = guessedWord;
            System.out.println("You have guessed the word '" + guessedWord + "'!");
            return correctGuesses;
          }else if(correctGuesses[j].equals(guessedWord)){
            return correctGuesses;
          }
        }
      }
    }
    return correctGuesses; 
  }
  
  public static boolean isPrime(int num){
    for(int i=2; i<=num/2; i++){
      if(num%i==0){
        return false; // num is not prime if it does not have any factor that divides into it perfectly
      }
    }
    System.out.println(num);
    return true; // else num is prime
  }
  public static int[] findPrimes(int[] nums){
    int primesLength = 1;
    int[] primes = {}, tempArray = {};
    boolean isPrime = false;
    // find number of primes in nums array
    for(int i=0; i<nums.length; i++){
      isPrime = isPrime(nums[i]); // check if current number is prime
      if(isPrime){
        primesLength++; // if current number is prime, the number of primes increases by 1
        tempArray = new int[primesLength+1]; // create a new array with 
        for(int j=0; j<primesLength; j++){
          tempArray[j] = primes[j];
        }
        tempArray[primesLength-1] = nums[i];
        
        int[] primes = primes
      }
    }
    int[] primes = new int[primesLength];
    return primes;
  }
}