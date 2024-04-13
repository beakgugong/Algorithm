import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int[][] arr;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,1,0,-1};
  static int[][] dp;
  static int max = Integer.MIN_VALUE;
  static boolean[][] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    arr = new int[N][M];
    visit = new boolean[N][M];
    dp = new int[N][M];

    for (int i=0; i<N; i++){
      String str = br.readLine();
      for (int j=0; j<M; j++){
        if (str.charAt(j)=='H'){
          arr[i][j] = 0;
        }
        else {
          arr[i][j] = Integer.valueOf(str.charAt(j)-48);
        }
      }
    }
    dfs(0,0,0);
    System.out.println(max);
  }
  static void dfs(int x, int y, int count){
    if (x<0||y<0||x>M-1||y>N-1||arr[y][x]==0){
      max = Math.max(count,max);
      return;
    }
    if (visit[y][x]){
      System.out.println(-1);
      System.exit(0);
    }
    if (dp[y][x]>count){
      return;
    }

    visit[y][x] = true;
    count++;
    dp[y][x] = count;
    int num = arr[y][x];

    for (int i=0; i<4; i++){
      int nx = num*dx[i]+x;
      int ny = num*dy[i]+y;

      dfs(nx,ny,count);
    }
    visit[y][x] = false;
  }
}