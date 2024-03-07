import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int N;
  static int M;
  static int[][] map;
  static int[][] wall;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }
    dfs(0);

    System.out.println(max);

  }

  static void dfs(int wall) {
    if (wall == 3) {
      int tmp = bfs();
      if (max < tmp) {
        max = tmp;
      }
      ;
      return;
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          dfs(wall + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    wall = new int[N][M];
    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        wall[i][j] = map[i][j];
        if (wall[i][j] == 2) {
          queue.add(new int[]{i, j});
        }
      }
    }

    while (queue.size() != 0) {
      int[] tmp = queue.poll();

      if (tmp[0] > N - 1 || tmp[1] > M - 1 || tmp[1] < 0 || tmp[0] < 0) {
        continue;
      }

        wall[tmp[0]][tmp[1]] = 2;
        for (int i = 0; i < 4; i++) {
          int ny = dy[i] + tmp[0];
          int nx = dx[i] + tmp[1];
          if (ny <= (N-1) && nx <= (M-1)&& nx>=0 && ny>=0&& wall[ny][nx]==0){
            queue.add(new int[]{ny, nx});
          }
        }
    }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (wall[i][j] == 0) {
            count++;
          }
        }
      }
      return count;
    }
  }