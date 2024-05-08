import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    long[][] dp = new long[n+1][21];
    int[] arr = new int[n+1];
    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=1; i<n+1; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    dp[1][arr[1]] = 1;

    for (int i=2; i<n; i++){
      for (int j=0; j<21; j++){
        if (dp[i-1][j]>0) {
          long num = dp[i-1][j];
          if (j - arr[i] > -1 && j - arr[i] < 21) {
            dp[i][j - arr[i]] += num;
          }
          if (j + arr[i] > -1 && j + arr[i] < 21) {
            dp[i][j + arr[i]] += num;
          }
        }
      }
    }

    System.out.println(dp[n-1][arr[n]]);
  }
}