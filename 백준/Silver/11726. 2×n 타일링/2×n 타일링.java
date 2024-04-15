import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    
    if (N==1){
      System.out.println(1);
      System.exit(0);
    }
    
    int[] dp = new int[N+1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i=3; i<=N; i++){
      dp[i] = (dp[i-1]+dp[i-2])%10007;
    }
    System.out.println(dp[N]);
  }
}