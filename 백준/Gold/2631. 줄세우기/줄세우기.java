import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] arr = new int[N+1];
    int[] dp = new int[N+1];

    for (int i=1; i<N+1; i++){
      arr[i] = Integer.valueOf(br.readLine());
    }

    dp[1] = 1;
    for (int i=1; i<N+1; i++){
      for (int j=1; j<i; j++){
        if (arr[i]>arr[j]){
          dp[i] = Math.max(dp[i],dp[j]+1);
        }
        if (dp[i]==0){
          dp[i] = 1;
        }
      }
    }
    Arrays.sort(dp);
    System.out.println(N-dp[dp.length-1]);
  }
}