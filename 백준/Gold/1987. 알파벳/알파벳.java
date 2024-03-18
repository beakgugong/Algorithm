import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main
{
  static int N;
  static int M;
  static char[][] map;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  static boolean[][] visited;
  static int answer = Integer.MIN_VALUE;
  static Map<Character, Integer> hashmap;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(str.nextToken());
    M = Integer.valueOf(str.nextToken());
    map = new char[N][M];
    hashmap = new HashMap<>();
    visited = new boolean[N][M];

    for (int i=0; i<N; i++){
      String alpha = bufferedReader.readLine();
      for (int j=0; j<M; j++){
        map [i][j] = alpha.charAt(j);
      }
    }

    hashmap.put(map[0][0],1);
    dfs(0,0,1);

    System.out.println(answer);
  }
  static void dfs(int x, int y, int count){

    visited[y][x] = true;
    for (int i=0; i<4; i++){
      int nx = x+dx[i];
      int ny = y+dy[i];

      if (nx<0||ny<0||nx>M-1||ny>N-1||visited[ny][nx]){
        continue;
      }
      char tmp = map[ny][nx];
      if (hashmap.containsKey(tmp)){
        continue;
      }
      else {
        hashmap.put(tmp,1);
      }
      dfs(nx,ny,hashmap.size());
    }
    
    answer = Math.max(answer,count);
    visited[y][x] = false;
    hashmap.remove(map[y][x]);
  }
}