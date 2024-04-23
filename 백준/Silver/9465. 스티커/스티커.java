import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());

    for (int i=0; i<T; i++){
      int N = Integer.valueOf(br.readLine());
      StringTokenizer stringTokenizer;

      int[][] sticker = new int[2][N];
      int[][] dp = new int[2][N];

      for (int k=0; k<2; k++) {
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          sticker[k][j] = Integer.valueOf(stringTokenizer.nextToken());
        }
      }

      int max = Integer.MIN_VALUE;

      dp[0][0] = sticker[0][0];
      dp[1][0] = sticker[1][0];

      if (N==1){
        max = Math.max(dp[0][0],dp[1][0]);
        System.out.println(max);
        continue;
      }
      else {
        dp[0][1] = sticker[1][0]+sticker[0][1];
        dp[1][1] = sticker[0][0]+sticker[1][1];
        max = Math.max(dp[0][1],dp[1][1]);
      }

      for (int j=2; j<N; j++) {
        for (int k=0; k<2; k++){
          if (k==0){
            dp[k][j] = Math.max(dp[1][j-1],Math.max(dp[0][j-2],dp[1][j-2]))+sticker[k][j];
            max = Math.max(max,dp[k][j]);
          }
          else {
            dp[k][j] = Math.max(dp[0][j - 1], Math.max(dp[1][j - 2], dp[0][j - 2]))+sticker[k][j];
            max = Math.max(max, dp[k][j]);
          }
        }
      }
      System.out.println(max);
    }
  }
}