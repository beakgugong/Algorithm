import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static boolean[][] graph;
  static boolean[] visit;
  static int maxCount;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int V = Integer.valueOf(stringTokenizer.nextToken());
    graph = new boolean[N+1][N+1];
    visit = new boolean[N+1];

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());
      graph[x][y] = true;
      graph[y][x] = true;
      maxCount++;
    }

    dfs(V);
    System.out.println();
    visit = new boolean[N+1];
    bfs(V);
  }
  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visit[v] = true;

    while (!queue.isEmpty()){
      int next = queue.poll();
      System.out.print(next+" ");
      for (int j=1; j<graph.length; j++) {
        if (graph[next][j] && !visit[j]) {
          queue.add(j);
          visit[j] = true;
        }
      }
    }
  }
  static void dfs(int v){
    visit[v] = true;
    System.out.print(v+" ");

    for (int j=1; j<graph.length; j++){
      if (graph[v][j]&&!visit[j]){
        dfs(j);
      }
    }
  }
}