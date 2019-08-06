import java.util.Scanner;
import java.util.ArrayList;

public class example {
 static int rows, cols;
 static int[] moveRow = {-1, 0, 1, 0, 0};
 static int[] moveCol = {0, 1, 0, -1, 0};
 static ArrayList<String> paths = new ArrayList<String>(); //u = up, r = right, d = down, l = left, s = stay
 static ArrayList<Integer> items = new ArrayList<Integer>(); //parallel arraylist to paths
 
 public static void main(String[] args) {
  
  Scanner scanner = new Scanner(System.in);
  rows = scanner.nextInt();
  cols = scanner.nextInt();
  int[][] map = new int[rows][cols];
  Pos start = new Pos(-1, -1);
  scanner.nextLine();
  
  for (int i = 0; i < rows; i++) {
   String input = scanner.nextLine();
   String[] temp = input.split(" ");
   for (int j = 0; j < cols; j++) {
    if (temp[j].equals(".")) {
     map[i][j] = 0;
    } else if (temp[j].equals("p")) {
     start = new Pos(i, j);
     map[i][j] = 0;
    } else {
     map[i][j] = Integer.parseInt(temp[j]);
    }
   }
  }
  
  iterate(start, 0, map, "", 0);
  
  if (paths.size() == 0) {
   System.out.println("Impossible to get to center.");
  } else {
   System.out.println("Total paths found: " + paths.size());
   
   int maxIndex = 0;
   for (int i = 1; i < paths.size(); i++) {
    if (items.get(i) > items.get(maxIndex)) {
     maxIndex = i;
    }
   }
   
   System.out.println("Optimal path: " + paths.get(maxIndex));
   System.out.println(items.get(maxIndex) + " items(s) looted on optimal path.");
  }
 }
 
 public static void iterate(Pos curPos, int curStorm, int[][] curMap, String curPath, int curLoot) { //bursts through all possible paths and adds solutions to paths and items ArrayLists
  if (curStorm == Math.min(rows, cols)/2 && curPos.row == rows/2 && curPos.col == cols/2) {
   paths.add(curPath);
   items.add(curLoot);
  } else {
   for (int i = 0; i < 5; i++) {
    Pos newPos = new Pos(curPos.row + moveRow[i], curPos.col + moveCol[i]);
    
    if (newPos.row >= 0 && newPos.row < rows && newPos.col >= 0 && newPos.col < cols) { //if in bounds of map
     int lootValue = curMap[newPos.row][newPos.col];
     int newStorm = curStorm + + lootValue + 1;
     int newLoot = curLoot + lootValue;
     
     if (newPos.row >= newStorm && newPos.row < rows-newStorm && newPos.col >= newStorm && newPos.col < cols-newStorm) { //if not in storm
      int[][] newMap = copyMap(curMap);
      newMap[newPos.row][newPos.col] = 0;
      
      String newPath = curPath;
      if (i == 0) {
       newPath += "u";
      } else if (i == 1) {
       newPath += "r";
      } else if (i == 2) {
       newPath += "d";
      } else if (i == 3) {
       newPath += "l";
      } else {
       newPath += "s";
      }
      
      iterate(newPos, newStorm, newMap, newPath, newLoot);
     }
    }
   }
  }
 }
 
 public static int[][] copyMap(int[][] curMap) {
  int[][] newMap = new int[rows][cols];
  
  for (int i = 0; i < rows; i++) {
   for (int j = 0; j < cols; j++) {
    newMap[i][j] = curMap[i][j];
   }
  }
  
  return newMap;
 }
}

class Pos {
 int row;
 int col;
 
 Pos (int row, int col) {
  this.row = row;
  this.col = col;
 }
}
