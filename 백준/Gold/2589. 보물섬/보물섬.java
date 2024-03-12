import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static boolean[][] visited;
  static char[][] cost;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    cost = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = bufferedReader.readLine();
      for (int j = 0; j < M; j++) {
        if (str.charAt(j) == 'L') {
          cost[i][j] = 1;
        }
      }
    }

    int answer = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (cost[i][j] == 1) {
          visited = new boolean[N][M];
          int tmp = bfs(i, j);
          answer = Math.max(tmp,answer);
        }
      }
    }
    System.out.println(answer);
  }

  static int bfs(int k, int j){
    Queue<Node> queue = new LinkedList<>();
    Node node = new Node(j,k,0);
    queue.add(node);
    int tmp = Integer.MIN_VALUE;
    visited[node.y][node.x] = true;

      while (!queue.isEmpty()) {
        Node n = queue.poll();
        int x = n.x;
        int y = n.y;


        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
            continue;
          }
          if (cost[ny][nx] == 0) {
            continue;
          }
          if (visited[ny][nx] == true) {
            continue;
          }
          visited[ny][nx] = true;
          queue.add(new Node(nx,ny,n.count+1));

          tmp = Math.max(tmp, n.count+1);

        }
      }

    queue.clear();
    return tmp;
  }
  static class Node{
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}