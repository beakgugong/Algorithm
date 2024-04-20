import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[N+2];
    int[] t = new int[N+1];
    int[] p = new int[N+1];
    StringTokenizer stringTokenizer;
    int max = Integer.MIN_VALUE;

    for (int i=1; i<N+1; i++){
      stringTokenizer = new StringTokenizer(br.readLine());

      t[i] = Integer.valueOf(stringTokenizer.nextToken());
      p[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=1; i<N+1; i++){
      max = Math.max(max,dp[i]);
      if (i+t[i]>N+1){
        continue;
      }
      
      int tmp = Math.max(max,dp[i]);
      dp[i+t[i]] = Math.max(dp[i+t[i]],tmp+p[i]);
     
    }
    Arrays.sort(dp);
    System.out.println(dp[N+1]);
  }
}