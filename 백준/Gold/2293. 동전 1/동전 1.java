import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(stringTokenizer.nextToken());
    int k = Integer.valueOf(stringTokenizer.nextToken());
    int[] coin = new int[n];
    int[] dp = new int[10001];
    dp[0] = 1;

    for (int i=0; i<n; i++){
      coin[i] = Integer.valueOf(br.readLine());
    }

    for (int i=0; i<coin.length; i++){
      for (int j=1; j<dp.length; j++) {
        if (j>=coin[i]) {
          dp[j] = dp[j] + dp[j - coin[i]];
        }
      }
    }
    System.out.println(dp[k]);

  }
}