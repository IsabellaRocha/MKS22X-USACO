import java.io.*;
import java.util.*;
public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    int[][] ary = makeArray(filename);
    String output = "";
    for (int idx = 0; idx < ary.length; idx++) {
      output += "\n";
      for (int x = 0; x < ary[idx].length; x++) {
        output += ary[idx][x];
      }
    }
    System.out.println(output);
    return 1;
  }
  public static int silver(String filename) {
    return 1;
  }
  private static int[][] makeArray(String x) throws FileNotFoundException{
    File text = new File(x);
    Scanner in = new Scanner(text);
    int r = 0;
    int c = 0;
    while (in.hasNextLine()) {
      r++;
      String line = in.nextLine();
      c = line.length();
    }
    int[][] ary = new int[r][c];
    in = new Scanner(text);
    for (int i = 0; i < r; i++) {
      String[] row = in.nextLine().split(" ");
      for (int idx = 0; idx < c; idx++) {
        ary[i][idx] = Integer.parseInt(row[idx]);
      }
    }
    return ary;
  }
  public static void main(String[] args) {
    try {
      bronze("test.txt");
    }
    catch (FileNotFoundException e) {}
  }
}
