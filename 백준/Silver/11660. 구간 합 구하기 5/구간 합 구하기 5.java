import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[][] arr = new int[N+1][N+1];
    int[][] dp = new int[N+1][N+1];
    for (int i=1; i<N+1; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int tmp = 0;
      for (int j=1; j<N+1; j++) {
        arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
      }
    }

    int[] start;
    int[] end;
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      start = new int[]{Integer.valueOf(stringTokenizer.nextToken()), Integer.valueOf(stringTokenizer.nextToken())};
      end = new int[]{Integer.valueOf(stringTokenizer.nextToken()), Integer.valueOf(stringTokenizer.nextToken())};

      int answer = dp[end[0]][end[1]] - dp[start[0]-1][end[1]]-dp[end[0]][start[1]-1]+dp[start[0]-1][start[1]-1];
      stringBuffer.append(answer+"\n");
    }
    System.out.println(stringBuffer);
  }
}