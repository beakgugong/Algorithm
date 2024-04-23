import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] grape;
  static int max = Integer.MIN_VALUE;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    grape = new int[N+1];
    int[] dp = new int[N+1];

    for (int i=1; i<N+1; i++){
      grape[i] = Integer.valueOf(br.readLine());
    }
    dp[1] = grape[1];
    if (N > 1) {
      dp[2] = grape[1] + grape[2];
    }

    for (int i=3; i<N+1; i++){
      dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+grape[i],dp[i-3]+grape[i-1]+grape[i]));
    }

    System.out.println(dp[N]);
  }
}