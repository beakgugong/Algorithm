import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};
  static int[][] land;
  static boolean[][] visited;
  static int N;
  static int M;
  static int answer = 0;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    M = Integer.parseInt(stringTokenizer.nextToken());
    N = Integer.parseInt(stringTokenizer.nextToken());
    land = new int[N][M];
    visited = new boolean[N][M];
    Queue<int[]> queue = new LinkedList<>();
    int minusCount = 0;

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        land[i][j] = Integer.parseInt(stringTokenizer.nextToken());
        if (land[i][j] == 1) {
          queue.add(new int[]{i, j});
          count++;
          visited[i][j] = true;
        } else if (land[i][j] == -1) {
          minusCount++;
        }
      }
    }
    
    bfs(queue);

    if (count+minusCount != N*M){
      System.out.println(-1);
      return;
    }

    System.out.println(answer-1);
  }
  static void bfs(Queue<int[]> queue) {
    Queue<int[]> que2 = new LinkedList<>();


    if (queue.size()==0)
      return;

    while (!queue.isEmpty()) {
      int y = queue.peek()[0];
      int x = queue.peek()[1];
      queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx<0||ny<0||ny>N-1||nx>M-1||land[ny][nx]==-1||visited[ny][nx]) continue;

        que2.add(new int[]{ny, nx});
        count++;
        visited[ny][nx] = true;
      }
    }
    answer++;
    bfs(que2);
    return;
  }
}