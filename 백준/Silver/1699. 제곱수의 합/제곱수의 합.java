import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[100001];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i=4; i<dp.length; i++){
      dp[i] = i;
    }

    for (int i=1; i<dp.length; i++){
      for (int j=1; j<=Math.sqrt(i); j++){
        dp[i]=Math.min(dp[i],dp[i-(j*j)]+1);
      }
    }

    System.out.println(dp[N]);

  }
}