import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};
  static int[][] paper;
  static boolean[][] visited;
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(stringTokenizer.nextToken());
    M = Integer.parseInt(stringTokenizer.nextToken());
    int answer = 0;
    int count = 0;
    paper = new int[N][M];
    visited = new boolean[N][M];
    Queue<int[]> queue = new LinkedList<>();


    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        paper[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (paper[i][j] == 0||visited[i][j]){
          continue;
        }
        count++;
        answer = Math.max(bfs(i,j), answer);
      }
    }
    System.out.println(count);
    System.out.println(answer);
  }

  public static int bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i, j});
    visited[i][j] = true;
    int count = 0;

    while (!queue.isEmpty()){
      int y = queue.peek()[0];
      int x = queue.peek()[1];
      queue.poll();
      count++;

      for (int k=0; k<4; k++){
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (nx<0||ny<0||nx>M-1||ny>N-1||paper[ny][nx]==0||visited[ny][nx]){
          continue;
        }
        queue.add(new int[]{ny, nx});
        visited[ny][nx] = true;
      }
    }

    return count;
  }
}