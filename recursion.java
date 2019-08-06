/* recursion.java
 * This program contains recursion method exercises
 * @author Matthew Ao
 * @version 1.0.0
 */

import java.util.Scanner;

class recursion{
  public static int max = 0;
  public static int current = 0;
    
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    // astrixCount method 
    char[] randomChars = new char[10];
    for(int i = 0; i < 10; i++){
      System.out.println("Enter a character: ");
      randomChars[i] = input.next().charAt(0);
    }
    int numAstrix = astrixCount(randomChars);
    System.out.println("There longest chain of continuous asterisks in this array is " + numAstrix + " asterisks.");
    
    // outputNumericPalindromes method
    System.out.println("Enter a number: ");
    int num = input.nextInt();
  }
  
  public static int astrixCount(char[] data){
    
    // base case
    if (data.length == 1){
      if (data[0] == '*'){
        current++;
        max(current);
        return max;
      }
      return max;
    }
    // if the first element in the array is *
    if (data[0] == '*'){
      char[] temp = new char[data.length-1];
      // add all of first array to a temporary array, excluding the first element
      for(int i=0; i<temp.length; i++){
        temp[i] = data[i+1];
      }
      current++;
      max(current);
      return astrixCount(temp);
    }else{
      char[] temp = new char[data.length-1];
      for(int i=0; i<temp.length; i++){
        temp[i] = data[i+1];
      }
      current = 0;
      return astrixCount(temp);
    }
  }
  
  public static int max(int current){
    if (current > max){
      max = current;
      return max; 
    }
    return max;
  }
  
  public static void outputNumericPalindromes(int num, int index){
    int numOfPalindromes = 0;
    int[] outputs = new int[numOfPalindromes];
    if(index < num.length-1){
      if(num%(Math.floor(Math.pow(10, index)))==num/){
      }
      outputNumericPalindromes(num, index+1);
    }
    // return base case 
    
    if(num%Math.round(Math.pow(10, index+1) == 0)){
      return null;
    }
    //for(int i=0; i<outputs.length; i++){
      //System.out.println(outputs[i]);
    //}
  }
}