import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int L,R,N;
  static int amount;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static boolean[][] visited;
  static int[][] map;
  static Queue<int[]> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    L = Integer.valueOf(stringTokenizer.nextToken());
    R = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][N];
    visited = new boolean[N][N];
    int answer = 0;
    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    while (true) {
      int flag = 0;
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            amount = map[i][j];
            queue.add(new int[]{i, j});
            dfs(i, j);

            int divide = queue.size();
            if (divide == 1) {
              queue.clear();
            }
            int people = amount / divide;
            while (!queue.isEmpty()) {
              map[queue.peek()[0]][queue.peek()[1]] = people;
              queue.poll();
              flag = 1;
            }
          }
        }
      }
      if (flag==0) {
        break;
      }
      answer++;
    }
    System.out.println(answer);
  }
  static void dfs(int y, int x){
    visited[y][x]= true;

    for (int k=0; k<4; k++){
      int nx = x+dx[k];
      int ny = y+dy[k];
      if (nx<0||ny<0||nx>N-1||ny>N-1||visited[ny][nx]==true){
        continue;
      }
      if(Math.abs(map[ny][nx]-map[y][x])<L||Math.abs(map[ny][nx]-map[y][x])>R){
        continue;
      }
      queue.add(new int[] {ny,nx});
      amount+=map[ny][nx];
      dfs(ny,nx);
    }
  }
}