import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[N+1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i=2; i<N+1; i++){
      dp[i] = (dp[i-1]+2*dp[i-2])%10007;
    }

    System.out.println(dp[N]);
  }
}