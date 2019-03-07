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
    int[][] ary = new int[R][C];
    for (int i = 0; i < R; i++) {
      for (int idx = 0; idx < C; idx++) {
        ary[i][idx] = in.nextInt();
      }
    }
    int[][] ins = new int[N][3];
    for (int idx = 0; idx < N; idx++) {
      for (int x = 0; x < 3; x++) {
        ins[idx][x] = in.nextInt();
      }
    }
    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(ins));
    return 1;
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
