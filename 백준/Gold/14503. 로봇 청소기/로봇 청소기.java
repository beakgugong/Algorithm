import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int N;
  static int M;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static boolean[][] visit;
  static int answer = 1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][M];
    visit = new boolean[N][M];
    stringTokenizer = new StringTokenizer(br.readLine());
    int y = Integer.valueOf(stringTokenizer.nextToken());
    int x = Integer.valueOf(stringTokenizer.nextToken());
    int d = Integer.valueOf(stringTokenizer.nextToken());

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }
    dfs(d,x,y);

    System.out.println(answer);
  }
  static void dfs(int d, int x, int y){
    int count = 0;
    map[y][x] = -1;

    while (count<4){
      d = (d+3)%4;
      int nx = dx[d]+x;
      int ny = dy[d]+y;

      if (nx>=0&&ny>=0&&nx<=M-1&&ny<=N-1){
        if (map[ny][nx]==0){
          answer++;
          dfs(d,nx,ny);
          return;
        }
      }
      count++;
    }

    int dir = (d + 2) % 4;
    int bx = x + dx[dir];
    int by = y + dy[dir];
    if(bx >= 0 && by >= 0 && bx < M && by < N && map[by][bx] != 1) {
      dfs(d, bx, by);
    }
  }
}