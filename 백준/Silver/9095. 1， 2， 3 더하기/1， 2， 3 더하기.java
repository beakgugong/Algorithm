import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    int dp[] = new int[12];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i=4; i<12; i++){
      dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }

    for (int i=0; i<T; i++) {
      int num = Integer.valueOf(br.readLine());
      
      System.out.println(dp[num]);
    }
  }
}