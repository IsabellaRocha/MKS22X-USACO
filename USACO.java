import java.io.*;
import java.util.*;
public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner in = new Scanner(text);
    int R = in.nextInt();
    int C = in.nextInt();
    int E = in.nextInt();
    int N = in.nextInt();
    System.out.println(R);
    int[][] field = new int[R][C];
    for (int idx = 0; idx < R; idx++) {
      for (int x = 0; x < C; x++) {
        field[idx][x] = in.nextInt();
      }
    }
    int[][] ins = new int[N][3];
    for (int idx = 0; idx < N; idx++) {
      for (int x = 0; x < 3; x++) {
        ins[idx][x] = in.nextInt();
      }
    }
    for (int idx = 0; idx < ins.length; idx++) {
      stomp(field, ins, idx);
    }
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (E - field[row][col] > 0) field[row][col] = E - field[row][col];
        else field[row][col] = 0;
      }
    }
    return 1;
  }
  private static String toString(int[][] field) {
    String output = "";
    for (int idx = 0; idx < field.length; idx++) {
      output += "\n";
      for (int x = 0; x < field[idx].length; x++) {
        output += field[idx][x] + " ";
      }
    }
    return output;
  }
  private static void stomp(int[][] field, int[][] ins, int idx) {
    int r = ins[idx][0] - 1;
    int c = ins[idx][1] - 1;
    int stomps = ins[idx][2];
    int max = Math.max(field[r][c],
              Math.max(field[r + 1][c],
              Math.max(field[r + 2][c],
              Math.max(field[r][c + 1],
              Math.max(field[r][c + 2],
              Math.max(field[r + 1][c + 1],
              Math.max(field[r + 1][c + 2],
              Math.max(field[r + 2][c + 1],
                       field[r + 2][c + 2]))))))));
    System.out.println(max);
    for (int x = 0; x < stomps; x++) {
      for (int row = 0; row < r + 3; r++) {
        for (int col = 0; col < r + 3; col++) {
          if (field[row][col] == max) {
            field[row][col]--;
          }
        }
      }
      max--;
    }
  }
  public static int silver(String filename) {
    return 1;
  }
  public static void main(String[] args) {
    try {
      bronze("test.txt");
    }
    catch (FileNotFoundException e) {}
  }
}
