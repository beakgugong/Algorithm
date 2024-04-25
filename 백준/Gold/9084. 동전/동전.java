import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());

    for (int i=0; i<T; i++) {

      int N = Integer.valueOf(br.readLine());
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      int[] coin = new int[N];
      int[] dp = new int[10001];
      dp[0] = 1;

      for (int j=0; j<N; j++){
        coin[j] = Integer.valueOf(stringTokenizer.nextToken());
      }
      int money = Integer.valueOf(br.readLine());

      for (int j = 0; j < coin.length; j++) {
        for (int k = 1; k < dp.length; k++) {
          if (k >= coin[j]) {
            dp[k] = dp[k] + dp[k - coin[j]];
          }
        }
      }
      System.out.println(dp[money]);
    }
  }
}