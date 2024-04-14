import java.io.*;
import java.util.*;

public class Main {

  private static int T, W;
  private static int[] arr;
  private static int[][][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    arr = new int[T + 1];
    for (int i = 1; i <= T; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp = new int[3][T + 1][W + 2];

    for (int i = 1; i <= T; i++) {
      for (int j = 1; j <= W + 1; j++) {
        if (arr[i] == 1) {
          dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
          dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
        } else {
          if (i == 1 && j == 1) continue;
          dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
          dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
        }
      }
    }

    int result = 0;
    for (int i = 1; i <= W + 1; i++) {
      result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
    }

    System.out.println(result);
  }
}