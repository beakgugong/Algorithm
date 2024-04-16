import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[] number = new int[N+1];
    long[][][] dp = new long[2][N+1][1];
    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=1; i<N+1; i++){
      number[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    dp[1][1][0] = number[1];

    for (int i=1; i<N+1; i++)
    {
      dp[1][i][0] = dp[1][i-1][0]+number[i];
    }

    for (int k=0; k<M; k++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int i = Integer.valueOf(stringTokenizer.nextToken());
      int j = Integer.valueOf(stringTokenizer.nextToken());

      System.out.println(dp[1][j][0]-dp[1][i-1][0]);
    }
  }
}