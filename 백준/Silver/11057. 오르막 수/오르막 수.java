import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[][] dp = new int[1001][10];

    for (int i=0; i<10; i++){
      dp[0][i] = 1;
    }

    for (int i=1; i<1001; i++){
      dp[i][9] = 1;
      for (int j=8; j>-1; j--){
        dp[i][j] = (dp[i][j+1]+dp[i-1][j])%10007;
      }
    }
    System.out.println(dp[N][0]);
  }
}