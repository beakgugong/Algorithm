import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
  static int N;
  static int M;
  static char[][] map;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  static boolean[][] duckVisite;
  static int count;
  static Queue<int[]> sq, dq;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str= new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(str.nextToken());
    M = Integer.valueOf(str.nextToken());
    map = new char[N][M];

    ArrayList<Duck> arrayList = new ArrayList<>();
    sq = new LinkedList<>();
    dq = new LinkedList<>();

    for (int i=0; i<N; i++){
      String string = bufferedReader.readLine();
      for (int j=0; j<M; j++){
        map[i][j] = string.charAt(j);
        if (string.charAt(j)=='L'){
          arrayList.add(new Duck(j,i));
          dq.add(new int[]{i,j});
        } else if (string.charAt(j)=='.'||string.charAt(j)=='L') {
          dq.add(new int[]{i,j});
        }
      }
    }

    duckVisite = new boolean[N][M];
    sq.add(new int[]{arrayList.get(0).x,arrayList.get(0).y});
    duckVisite[arrayList.get(0).y][arrayList.get(0).x] = true;

    while (true) {
      if (meet(arrayList.get(1))) {
        System.out.println(count);
        break;
      }
      melt();
      count++;
    }
  }
  static void melt(){
    int size = dq.size();

    for (int i=0; i<size; i++){
      int[] tmp = dq.poll();

      for (int j=0; j<4; j++){
        int nx = tmp[1]+dx[j];
        int ny = tmp[0]+dy[j];
        if (nx<0|| ny<0|| nx>M-1|| ny>N-1){
          continue;
        }
        if (map[ny][nx]=='X'){
          map[ny][nx] = '.';
          dq.add(new int[]{ny,nx});
        }
      }
    }
  }
  static boolean meet(Duck two) {
    Queue<int[]> queue = new LinkedList<>();

    while (!sq.isEmpty()) {
      int[] tmp = sq.poll();
      int x = tmp[0];
      int y = tmp[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1 || duckVisite[ny][nx]) {
          continue;
        }
        if (ny==two.y&&nx==two.x){
          return true;
        }
        duckVisite[ny][nx] = true;
        if(map[ny][nx] == '.') {
          sq.add(new int[] {nx,ny});
        }else if(map[ny][nx] == 'X') {
          queue.add(new int[] {nx,ny});
        }
        queue.add(new int[]{nx, ny});
      }
    }
    sq = queue;
    return false;
  }
  static class Duck{
    int x;
    int y;

    public Duck(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}