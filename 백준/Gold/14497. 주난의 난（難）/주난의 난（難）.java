import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
  static int N;
  static int M;
  static char[][] map;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  static boolean[][] visited;
  static int[] target;
  static int count;
  static boolean flag = false;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str= new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(str.nextToken());
    M = Integer.valueOf(str.nextToken());
    str = new StringTokenizer(bufferedReader.readLine());
    int[] jun = {Integer.valueOf(str.nextToken()),Integer.valueOf(str.nextToken())};
    target = new int[]{Integer.valueOf(str.nextToken()),Integer.valueOf(str.nextToken())};
    map = new char[N][M];
    visited = new boolean[N][M];

    for (int i=0; i<N; i++){
      String string = bufferedReader.readLine();
      for (int j=0; j<M; j++){
        map[i][j] = string.charAt(j);
      }
    }
    while (true){
      dfs(jun[1]-1,jun[0]-1);
      for (int i=0; i<N; i++){
        for (int j=0; j<M; j++){
          visited[i][j]= false;
        }
      }
      if (flag) {
        System.out.println(count + 1);
        break;
      }
      count++;
    }
  }
  static void dfs(int x, int y){
    visited[y][x] = true;
    if (map[y][x]=='1'){
      map[y][x] = '0';
      return;
    }
    if (map[y][x]=='#'){
      flag = true;
      return;
    }
    for (int i=0; i<4; i++){
      int nx = x+dx[i];
      int ny = y+dy[i];

      if (nx<0|| ny<0|| nx>M-1|| ny>N-1||visited[ny][nx]){
        continue;
      }
      dfs(nx,ny);
    }
  }
}