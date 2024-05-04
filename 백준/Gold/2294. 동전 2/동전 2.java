import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
  static int N;
  static int K;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    K = Integer.valueOf(stringTokenizer.nextToken());
    arr = new int[N];
    int[] dp = new int[K+1];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.valueOf(br.readLine());
    }
    Arrays.sort(arr);

    for (int i=0; i<N; i++){
      for (int j=1; j<K+1; j++){
        if (j%arr[i]==0){
          if (dp[j]!=0){
            dp[j] = Math.min(j/arr[i],dp[j]);
          }
          else dp[j] = j/arr[i];
        }
        else {
          int num = 1;
          for (int k=arr[i]; k<=j; k*=num){
            if (dp[k]!=0&&dp[j-k]!=0){
              if (dp[j]!=0) {
                dp[j] = Math.min(dp[k] + dp[j - k], dp[j]);
              }
              else dp[j] = dp[k]+dp[j - k];
            }
            num++;
          }
        }
      }
    }

    if (dp[K]==0){
      System.out.println(-1);
      return;
    }
    System.out.println(dp[K]);
  }
}