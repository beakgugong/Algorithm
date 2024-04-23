import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    long dp[] = new long[1000001];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i=4; i<1000001; i++){
      dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
    }

    for (int i=0; i<T; i++) {
      int num = Integer.valueOf(br.readLine());

      System.out.println(dp[num]);
    }
  }
}