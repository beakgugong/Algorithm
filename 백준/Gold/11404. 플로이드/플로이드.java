import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[][] city;
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    city = new int[N+1][N+1];
    int[][] dp = new int[N+1][N+1];

    for (int i = 1; i <N+1; i++) {
      Arrays.fill(dp[i], 100000001);
      dp[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      stringTokenizer =  new StringTokenizer(br.readLine());
      int a = Integer.valueOf(stringTokenizer.nextToken());
      int b = Integer.valueOf(stringTokenizer.nextToken());
      int cost = Integer.valueOf(stringTokenizer.nextToken());
      dp[a][b] = Math.min(cost,dp[a][b]);
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        for (int k = 1; k <= N; k++) {
          dp[j][k] = Math.min(dp[j][i]+dp[i][k], dp[j][k]);
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (dp[i][j] == 100000001) {
          System.out.print(0+" ");
          continue;
        }
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
}