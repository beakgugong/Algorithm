import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[][] map = new int[N][M];
    int[][] dp = new int[N][M];
    int[][] tmp = new int[2][M];

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    dp[0][0] = map[0][0];

    for (int i = 1; i < M; i++) {
      dp[0][i] = map[0][i] + dp[0][i - 1];
    }

    for (int i = 1; i < N; i++) {

      tmp[0][0] = dp[i-1][0] + map[i][0];
      for (int j = 1; j < M; j++) {
        tmp[0][j]  = Math.max(tmp[0][j-1], dp[i-1][j]) + map[i][j];
      }

      tmp[1][M-1] = dp[i-1][M-1] + map[i][M-1];
      for (int j = M-2; j >-1; j--) {
        tmp[1][j]  = Math.max(tmp[1][j+1], dp[i-1][j]) + map[i][j];
      }

      for (int j = 0; j < M; j++) {
        dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
      }
    }

    System.out.println(dp[N-1][M-1]);

  }
}