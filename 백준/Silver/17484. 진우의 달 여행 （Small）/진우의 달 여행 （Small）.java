import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[][] map;
  static int[] dx = {-1,0,1};
  static int[] dy = {1,1,1};
  static int min = Integer.MAX_VALUE;
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][M];


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i=0; i<M; i++){
      dfs(0,i,map[0][i], -1);
    }
    System.out.println(min);
  }
  static void dfs(int row, int column,int price, int direction){
    if (price>min){
      return;
    }
    if (row==N-1){
      min = price;
      return;
    }

    for (int i=0; i<3; i++){
      int nx = column+dx[i];
      int ny = row+dy[i];

      if (nx<0||ny<0||nx>M-1||ny>N-1||direction==i){
        continue;
      }
      dfs(ny,nx,price+map[ny][nx],i);
    }
  }
}