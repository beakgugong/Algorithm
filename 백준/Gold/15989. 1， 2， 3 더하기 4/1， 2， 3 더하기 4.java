import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[10001];
    dp[0] = 1;

    for (int i=1; i<=3; i++){
      for (int j=1; j<10001; j++){
        if (j-i>=0){
          dp[j] += dp[j-i];
        }
      }
    }

    for (int i=0; i<N; i++){
      System.out.println(dp[Integer.valueOf(br.readLine())]);
    }
  }
}