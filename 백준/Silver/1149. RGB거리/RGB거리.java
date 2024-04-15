import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] cost;
  static int min= Integer.MAX_VALUE;
  static int[] RGB = {0,1,2};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    cost = new int[N][3];
    int[][] dp = new int[N][3];

    StringTokenizer stringTokenizer;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<3; j++) {
        cost[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }
    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];

    for (int i=1; i<N; i++){
      for (int j=0; j<3; j++) {
        if (j==0) {
          dp[i][j] = Math.min(dp[i-1][1],dp[i-1][2])+cost[i][j];
        } else if (j==1) {
          dp[i][j] = Math.min(dp[i-1][0],dp[i-1][2])+cost[i][j];
        } else if (j==2) {
          dp[i][j] = Math.min(dp[i-1][0],dp[i-1][1])+cost[i][j];
        }
      }
    }
    min = Math.min(dp[N-1][0],dp[N-1][1]);
    min = Math.min(min,dp[N-1][2]);

    System.out.println(min);
  }
}