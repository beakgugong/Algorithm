import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0,-1,0,1};
  static int[] dy = {1,0,-1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    int number = 1;

    while (true) {
      int N = Integer.valueOf(br.readLine());

      if (N==0){
        break;
      }

      int[][] map = new int[N][N];
      boolean[][] visit = new boolean[N][N];
      Queue<int[]> queue = new LinkedList<>();
      int[][] costMap = new int[N][N];

      for (int i=0; i<N; i++){
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int j=0; j<N; j++){
          map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
          costMap[i][j] = Integer.MAX_VALUE;
        }
      }
      queue.add(new int[]{0,0});
      costMap[0][0] = map[0][0];

      while (!queue.isEmpty()){
        int y = queue.peek()[0];
        int x = queue.peek()[1];
        queue.poll();

        for (int i=0; i<4; i++){
          int ny = y+dy[i];
          int nx = x+dx[i];

          if (ny<0||nx<0||nx>N-1||ny>N-1){
            continue;
          }
          if (visit[ny][nx]&&costMap[ny][nx]<=costMap[y][x]+map[ny][nx]){
            continue;
          }
          costMap[ny][nx] = costMap[y][x]+map[ny][nx];
          visit[ny][nx] = true;
          queue.add(new int[]{ny,nx});
        }
      }
      System.out.println("Problem "+number+": "+costMap[N-1][N-1]);
      number++;
    }
  }
}