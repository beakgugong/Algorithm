import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int N;
  static int M;
  static boolean[][] map;
  static boolean[][][] visit;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new boolean[N][M];
    visit = new boolean[N][M][2];
    Queue<int[]> queue = new LinkedList<>();
    int answer = Integer.MAX_VALUE;

    for (int i=0; i<N; i++){
      String str = br.readLine();
      for (int j=0; j<M; j++){
        if (str.charAt(j)=='1'){
          map[i][j] = true;
        }else map[i][j] = false;
      }
    }
    
    if (N == 1 && M == 1) {
      System.out.println(1);
      return;
    }
    
    queue.add(new int[]{0,0,1,0});
    Loop1:
    while (!queue.isEmpty()) {
      int x = queue.peek()[1];
      int y = queue.peek()[0];
      int count = queue.peek()[2];
      int flag = queue.peek()[3];

      queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
          continue;
        }
        if (map[ny][nx]==false){
          if (flag==0&&!visit[ny][nx][0]){
            queue.add(new int[]{ny,nx,count+1,0});
            visit[ny][nx][0] = true;
          } else if (flag==1&&!visit[ny][nx][1]) {
            queue.add(new int[]{ny,nx,count+1,1});
            visit[ny][nx][1] = true;
          }
        }else {
          if (flag==0&&!visit[ny][nx][0]){
            queue.add(new int[]{ny,nx,count+1,1});
            visit[ny][nx][0] = true;
          }
        }
        if (nx == M - 1 && ny == N - 1) {
          answer = Math.min(answer, count + 1);
          break Loop1;
        }
      }
    }
    System.out.println(answer==Integer.MAX_VALUE?-1:answer);
  }
}