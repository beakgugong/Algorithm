import java.io.*;
import java.util.*;

public class Main {
  static int[][] arr;
  static int N;
  static int[] dx = {1, 0, 1, -1};
  static int[] dy = {0, 1, 1, 1};
  static int min;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = 1;

    while (true) {
      min = Integer.MAX_VALUE;
      N = Integer.valueOf(br.readLine());
      arr = new int[N+1][3];
      dp = new int[N+1][3];

      if (N == 0) {
        break;
      }
      dp[0][0] = Integer.MAX_VALUE;
      dp[0][1] = Integer.MAX_VALUE;
      dp[0][2] = Integer.MAX_VALUE;

      for (int i = 1; i < N+1; i++) {
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
          arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
          dp[i][j] = Integer.MAX_VALUE;
        }
      }

      dp[1][1] = arr[1][1];
      for (int i=1; i<dp.length; i++){
        for (int j=0; j<3; j++){
          if (j==0&&i!=1){
            dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1])+arr[i][j];
          }
          else if (j==1&&i!=1){
            dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]);
            dp[i][j] = Math.min(dp[i][j],dp[i-1][j+1]);
            dp[i][j] = Math.min(dp[i][j-1],dp[i][j])+arr[i][j];
          } else if (j==2) {
            dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]);
            dp[i][j] = Math.min(dp[i][j],dp[i][j-1])+arr[i][j];
          }
        }
      }

      System.out.println(num + ". " + dp[N][1]);
      num++;
    }
  }
}