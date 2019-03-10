import java.io.*;
import java.util.*;
public class USACO {
  public static int silver(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner in = new Scanner(text);
    int N = in.nextInt();
    int M = in.nextInt();
    int T = in.nextInt();
    String line = in.nextLine();
    char[][] field = new char[N][M];
    for (int idx = 0; idx < N; idx++) {
      line = in.nextLine();
      for (int x = 0; x < line.length(); x++) {
        field[idx][x] = line.charAt(x);
      }
    }
    int R1 = in.nextInt();
    int C1 = in.nextInt();
    int R2 = in.nextInt();
    int C2 = in.nextInt();
    int[][] poss = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    return 1;
  }
  private boolean canMove(int row, int col, int idx, int[][] poss, int[][] field) {
    try {
      return field[row + poss[idx][0]][col + poss[idx][1]] != '*';
    }
    catch(IndexOutOfBoundsException e) {}
    return false;
  }
  public static int bronze(String filename){
    try {
      File text = new File(filename);
      Scanner in = new Scanner(text);
      int R = in.nextInt();
      int C = in.nextInt();
      int E = in.nextInt();
      int N = in.nextInt();
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
      for (int idx = 0; idx < N; idx++) {
        field = stomp(field, ins, idx);
      }
      for (int row = 0; row < R; row++) {
        for (int col = 0; col < C; col++) {
          if (E - field[row][col] > 0) field[row][col] = E - field[row][col];
          else field[row][col] = 0;
        }
      }
      int depth = 0;
      for (int row = 0; row < R; row++) {
        for (int col = 0; col < C; col++) {
          depth += field[row][col];
        }
      }
      return depth * 72 * 72;
    }
    catch (FileNotFoundException e) {
      return 0;
    }
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
  private static String toString(char[][] field) {
    String output = "";
    for (int idx = 0; idx < field.length; idx++) {
      output += "\n";
      for (int x = 0; x < field[idx].length; x++) {
        output += field[idx][x] + " ";
      }
    }
    return output;
  }
  private static int[][] stomp(int[][] field, int[][] ins, int idx) {
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
    for (int x = 0; x < stomps; x++) {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          if (field[r + row][c + col] == max) {
            field[r + row][c + col]--;
          }
        }
      }
      max--;
    }
    return field;
  }
  public static void main(String[] args) {
    System.out.println(bronze("makelake.in"));
    System.out.println(bronze("testCases/makelake.2.in"));
  }
}
