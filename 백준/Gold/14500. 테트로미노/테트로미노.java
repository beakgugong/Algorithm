import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int N;
  static int M;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  static boolean[][] visit;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][M];
    visit = new boolean[N][M];

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i=0; i<N; i++){
      for (int j=0; j<M; j++){
        visit[i][j] = true;
        dfs(1,map[i][j],j,i);
        visit[i][j] = false;
      }
    }
    System.out.println(max);
  }

  static void dfs(int count, int sum, int x, int y){
    if (count==4){
      max = Math.max(max,sum);
      return;
    }

    for (int i=0; i<4; i++){
      int nx = dx[i]+x;
      int ny = dy[i]+y;

      if (nx<0||ny<0||nx>M-1||ny>N-1||visit[ny][nx]){
        continue;
      }
      if (count==2){
        visit[ny][nx] = true;
        dfs(count+1, sum+map[ny][nx], x, y);
        visit[ny][nx] = false;
      }

      visit[ny][nx] = true;
      dfs(count+1, sum+map[ny][nx], nx, ny);
      visit[ny][nx] = false;
    }
  }
}