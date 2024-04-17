import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] arr = new int[N+1];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    int[] dp = new int[N+1];
    dp[0] = arr[0];
    for (int i=1; i<N+1; i++){
      for (int j=0; j<i; j++){
        if (arr[i]>arr[j]&&dp[i]<dp[j]+arr[i]){
          dp[i] = dp[j]+arr[i];
        }
      }
      if (dp[i]==0){
        dp[i] = arr[i];
      }
    }
    
    Arrays.sort(dp);
    System.out.println(dp[N]);
  }
}