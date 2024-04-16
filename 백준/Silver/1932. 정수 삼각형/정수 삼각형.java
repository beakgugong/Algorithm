import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[][] triangle = new int[N][N];
    int[][] dp = new int[N][N];
    StringTokenizer stringTokenizer;
    int max = Integer.MIN_VALUE;
    
    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int num = 0;

      while (stringTokenizer.hasMoreTokens()){
        triangle[i][num] = Integer.valueOf(stringTokenizer.nextToken());
        num++;
      }
    }

    dp[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.length; i++) {
      dp[i][0] = dp[i - 1][0] + triangle[i][0];
      
      for (int j = 1; j <= i; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
      }
      dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
    }

    for (int i = 0; i < triangle.length; i++) {
      max = Math.max(max, dp[triangle.length - 1][i]);
    }
    System.out.println(max);
  }
}