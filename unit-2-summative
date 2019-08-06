/* BattleRoyale.java
 * This program uses an algorithm to optimize a player's approach to collecting loot in a battle-royale styled map as the walls of the map close in
 * @author Matthew Ao
 * @version 1.0.0
 */

// import classes
import java.io.File;
import java.util.Scanner;

// main class
class BattleRoyale{
  
  /**
   * A global 2D String array that contains a global map
   **/
  public static String[][] globalMap; 
  
  /**
   * A global int array that describes the player's position on the map
   **/
  public static int[] globalPos = { 0, 0 };
  
  /**
   * A global int that describes the global score
   **/
  public static int globalScore = 0;
  
  /**
   * Reads a file containing a Battle Royale map and recursively solves for the best path to the center
   * @param args Contains the supplied command-line arguments as an array of String objects
   * @throws Exception when the file scanner reads an error
   **/
  public static void main(String[] args) throws Exception{
    
    // initialize system scanner
    Scanner input = new Scanner(System.in);
    
    // display welcome text
    System.out.println("Welcome to Battle Royale.\n\nPlease enter the map file name to begin solving: ");
    
    // request map file and load map into map array
    String mapName = input.next();
    String[][] map = loadMap(mapName);
    globalMap = map;
    
    // print initial map to screen
    System.out.println("\n_________________________________");
    System.out.println("\nGENERATING MAP PREVIEW . . .");
    System.out.println("_________________________________\n");
    System.out.println("\nInitial Map:");
    displayMap(map);
    
    // declare variables for map properties
    int mapWidth = map[0].length;
    int mapMid = mapWidth/2;
    int maxTurns = mapMid;
    int[] playerPos = getPosition(map, mapWidth);
    int topScore = 0;
    
    // print map properties to screen
    System.out.println("\n\nNumber of Rows: " + mapWidth + "\nNumber of Columns: " + mapWidth);
    System.out.println("Center of Map Array: [" + mapMid + ", " + mapMid + "]");
    System.out.println("The player's maximum number of turns is: " + maxTurns);
    System.out.println("The player's starting position is: [" + playerPos[0] + ", " + playerPos[1] + "]");
    System.out.println("\n\n\n");
    
    // solve map for every starting position on the map
    for (int i=0; i<mapWidth; i++) { 
      for (int j=0; j<mapWidth; j++) {
        
        // set player position
        playerPos[0] = i;
        playerPos[1] = j;
        
        // use recursive method to find all possible paths in map
        findPath(map, mapWidth, playerPos, mapMid, -1, 0, maxTurns);
        
        // update top score and best starting position
        if (globalScore > topScore) { 
          topScore = globalScore;
          globalPos[0] = i;
          globalPos[1] = j;
        }
      }
    }
    
    // output map analysis complete 
    System.out.println("\n_________________________________");
    System.out.println("\nMAP ANALYSIS COMPLETE.");
    System.out.println("_________________________________\n");
    
    // if the global map is the same as the original map, no solution.
    if (globalMap == map){
      System.out.println("No solution possible.");
    } else {
      // otherwise, display the solved map 
      displayMap(globalMap);
      System.out.println("\n\nThe best location to drop the player is [" + globalPos[0] + ", " + globalPos[1] + "]. ");
      System.out.println("The maximum score is " + topScore + ". ");
    }
    // closing Scanner
    input.close();
  }
  
  
  /**
   * loadMap
   * Loads a map from a text file into a 2D array
   * @throws Exception when the file scanner reads an error
   * @param mapName A String describing the name of the text file
   * @return A 2D array containing the map grid
   **/
  public static String[][] loadMap(String mapName) throws Exception{
    
    // initiating file scanner and variables
    File mapFile = new File(mapName);
    Scanner fileInput = new Scanner(mapFile);
    String currentChar = "";
    int rowCount = 0;
    
    // read the first line of the map and create array properties
    String firstLine = fileInput.nextLine(); 
    int lineLength = firstLine.length(); 
    int arrayLength = firstLine.length()/2+1;
    
    // create map array
    String[][] map = new String[arrayLength][arrayLength];
    
    // add first line of text file to map manually
    for (int i=0; i<lineLength; i++) {
      currentChar = firstLine.substring(i, i+1);
      if (!(currentChar.equals(" "))) {
        map[0][rowCount] = currentChar;
        rowCount += 1;
      }
    }
    
    // add remaining lines of text file to map
    for (int i=1; i<arrayLength; i++) {
      for (int j=0; j<arrayLength; j++) {
        map[i][j] = fileInput.next();
      }
    }
    
    fileInput.close();
    return map;
  }
  
  /**
   * Prints a 2D array to the screen
   * @param map A 2D array containing the characters that make up the map grid
   **/
  public static void displayMap(String[][] map) {
    for (int i=0; i<map.length; i++) {
      System.out.print("\n");
      for (int j=0; j<map.length; j++) {
        System.out.print(map[i][j]);
        System.out.print(" ");
      }
    }
  }
  
  /**
   * Finds the player's position in the Battle Royal map
   * @param map A 2D array containing the map
   * @param mapWidth An int that describes the length of the map array's rows and columns
   * @return An int array containing indeces indicating the player's position in the map
   **/
  public static int[] getPosition(String[][] map, int mapWidth) {
    
    int[] pos = new int[2];
    
    // set player position to index of "P" in map array
    for (int i=0; i<mapWidth; i++) {
      for (int j=0; j<mapWidth; j++) {
        if (map[i][j].equalsIgnoreCase("P")) {
          pos[0] = i;
          pos[1] = j;
          
          // replace "P" with "."
          map[i][j] = ".";
        }
      }
    }
    
    return pos;
  }
  
  
  
  /**
   * Finds the number of points looted at this spot
   * @param map A 2D array containing the map
   * @param pos An int array containing the player's position, in the format { row, col }
   * @return An int describing the value of the loot collected at the player's given position on the map
   **/
  public static int collectLoot(String[][] map, int[] pos) {
    
    int lootValue = 0;
    
    // if the player's position has an integer, set loot value to that integer 
    if (!((map[pos[0]][pos[1]].equals(".")) || (map[pos[0]][pos[1]].equalsIgnoreCase("P")) || (map[pos[0]][pos[1]].equalsIgnoreCase("V")))) {
      lootValue = Integer.parseInt(map[pos[0]][pos[1]]);
    }
    
    return lootValue;
  }
  
  /**
   * Tests if the player's next position is out of bounds
   * @param map A 2D array containing the map
   * @param testPos An int array containing the position being tested, in the format { row, col }
   * @param mapWidth An int describing the length of the map array's rows and columns
   * @param boundsSize An int describing the size of the boundaries
   * @return True if the test position is within bounds and false otherwise
   **/
  public static boolean withinBounds(String[][] map, int[] testPos, int mapWidth, int boundsSize) {
    boolean withinBounds = true;
    
    // check up
    if (testPos[0] <= boundsSize) {
      withinBounds = false;
      // check down
    } else if (testPos[0] >= (mapWidth - boundsSize)) {
      withinBounds = false;
      // check left
    } else if (testPos[1] <= boundsSize) {
      withinBounds = false;
      // check right
    } else if (testPos[1] >= (mapWidth - boundsSize)) {
      withinBounds = false;
    } else {
      withinBounds = true;
    }
    return withinBounds;
  }
  
  /** 
   * Copies a 2D map array into a new 2D String array
   * @param map A 2D array containing the characters that make up the map grid
   * @param mapWidth An int that describes the length of the map array's rows and columns
   * @return A 2D array containing the copied map
   **/
  public static String[][] copyMap(String[][] map, int mapWidth){
    
    // create new array
    String[][] newMap = new String[mapWidth][mapWidth];
    
    // copy each element from old array into new array
    for (int i=0; i<mapWidth; i++){
      for (int j=0; j<mapWidth; j++){
        newMap[i][j] = map[i][j];
      }
    }
    
    return newMap;
  }
  
  /**
   * An algorithm that finds the optimal path for the player to take
   * @param map A 2D array containing the characters that make up the map grid
   * @param mapWidth An int that describes the length of the map array's rows and columns
   * @param pos An int array containing the player's position, in the format { row, col }
   * @param center An int that describes the center index of each row and column
   * @param boundsSize An int that describes the size of the out of bounds border
   * @param score An int that describes the player's current score
   * @param turns An int that describes the player's number of turns remaining
   **/
  public static void findPath(String[][] map, int mapWidth, int[] pos, int center, int boundsSize, int score, int turns) {
    
    // if the current position is out of bounds, terminate current iteration
    if (boundsSize >=0 && !withinBounds(map, pos, mapWidth, boundsSize)) {
      return;
    }
    
    // make a copy of the map
    String[][] newMap = copyMap(map, mapWidth);
    
    // declare variable for loot at player's current position
    int posLoot;
    
    // base case
    if ((turns <= 1) && (pos[0] == center) && (pos[1] == center)) { 
      
      // replace player's final position with "F"
      newMap[pos[0]][pos[1]] = "F";
      
      // collect loot from current position
      posLoot = collectLoot(map, pos);
      
      // add loot value to score
      score += posLoot;
      
      //System.out.println("Solution found with a score of " + score + " points.");
      
      // adjust the turn number and boundary shrink rate based on loot value
      if (posLoot > 1){
        boundsSize += posLoot;
        turns -= posLoot;
      } else {
        boundsSize += 1;
        turns -= 1;
      }
      
      // update global top score
      if (score > globalScore) {
        globalScore = score;
        globalPos = pos;
        globalMap = copyMap(newMap, mapWidth);
      }
      
      // output score and path
      
    } else {
      
      // set player's starting position to "P" on first turn
      if (boundsSize < 0) {
        newMap[pos[0]][pos[1]] = "P";
      } else {
        // else replace player's current position with "v" 
        newMap[pos[0]][pos[1]] = "v";
      }
      
      // collect loot from current position
      posLoot = collectLoot(map, pos);
      
      // add loot value to score
      score += posLoot;
      
      // adjust the turn number and boundary shrink rate based on loot value
      if (posLoot >= 1){
        boundsSize += posLoot;
        turns -= posLoot;
      } else {
        boundsSize += 1;
        turns -= 1;
      }
      
      // iterate recursive call for moving up
      int[] moveUp = { pos[0] - 1, pos[1] };
      findPath(newMap, mapWidth, moveUp, center, boundsSize, score, turns);
      
      // iterate recursive call for moving down
      int[] moveDown = { pos[0] + 1, pos[1] };
      findPath(newMap, mapWidth, moveDown, center, boundsSize, score, turns);
      
      // iterate recursive call for moving left
      int[] moveLeft = { pos[0], pos[1] - 1 };
      findPath(newMap, mapWidth, moveLeft, center, boundsSize, score, turns);
      
      // iterate recursive call for moving right
      int[] moveRight = { pos[0], pos[1] + 1 };
      findPath(newMap, mapWidth, moveRight, center, boundsSize, score, turns);
      
      // iterate recursive call for staying
      findPath(newMap, mapWidth, pos, center, boundsSize, score, turns);
    }
  }
}
