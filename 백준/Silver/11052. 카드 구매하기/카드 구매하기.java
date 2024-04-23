import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] card = new int[N+1];
    int[] dp = new int[N+1];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=1; i<N+1; i++){
      card[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    dp[1] = card[1];
    int max = 1;
    for (int i=2; i<N+1; i++){
      for (int j = 1; j<=i; j++){
        dp[i] = Math.max(dp[i],dp[i-j]+card[j]);
      }
    }
    System.out.println(dp[N]);
  }
}