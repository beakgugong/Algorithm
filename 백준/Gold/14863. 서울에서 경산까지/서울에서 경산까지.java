import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int k = Integer.parseInt(stringTokenizer.nextToken());
    long[][]dp = new long[n][100001];

    int[][] city = new int[n][4];

    for (int i=0; i<n; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int walkTime = Integer.valueOf(stringTokenizer.nextToken());
      int walkMoney = Integer.valueOf(stringTokenizer.nextToken());
      int bicycleTime = Integer.valueOf(stringTokenizer.nextToken());
      int bicycleMoney = Integer.valueOf(stringTokenizer.nextToken());

      city[i][0] = walkTime;
      city[i][1] = walkMoney;
      city[i][2] = bicycleTime;
      city[i][3] = bicycleMoney;
    }
    dp[0][city[0][0]] = city[0][1];
    dp[0][city[0][2]] = Math.max(city[0][3],dp[0][city[0][2]]);

    for (int i=1; i<n; i++){
      for (int j=0; j<=k; j++) {
        if (dp[i-1][j]>0){
          if (j+city[i][0]<=k){
            dp[i][j+city[i][0]] = Math.max(dp[i][j+city[i][0]],dp[i-1][j]+city[i][1]);
          }
          if (j+city[i][2]<=k){
            dp[i][j+city[i][2]] = Math.max(dp[i][j+city[i][2]],dp[i-1][j]+city[i][3]);
          }
        }
      }
    }

    long max = Integer.MIN_VALUE;
    for (int i=0; i<=k; i++){
      max = Math.max(dp[n-1][i],max);
    }
    System.out.println(max);
  }
}