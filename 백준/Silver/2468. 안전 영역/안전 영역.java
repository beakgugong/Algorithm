import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    int[][] location = new int[N][N];
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int tmp = 0;

    map.put(0,1);
    for(int i=0; i<N; i++){
      StringTokenizer str = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        location[i][j] = Integer.valueOf(str.nextToken());
        map.put(location[i][j],1);
      }
    }

    for (Integer i : map.keySet()){
      boolean[][] visited = new boolean[N][N];

      for(int j=0; j<N; j++){
        for(int k=0; k<N; k++){
          if (location[j][k]<=i)continue;
          if(dfs(i,j,k,location,visited)){
            tmp++;
          }
        }
      }
      if(tmp>max){
        max = tmp;
      }
      tmp = 0;
    }
    System.out.println(max);
  }

  private static boolean dfs(Integer i,int j, int k, int[][] location, boolean[][] visited) {
    if(j<0 || k<0 || j>N-1 || k>N-1){
      return false;
    }
    else if(visited[j][k]==true || location[j][k]<=i){
      return false;
    }
    visited[j][k] = true;
    for(int x=0; x<4; x++){
      int nx = k + dx[x];
      int ny = j + dy[x];
      dfs(i,ny,nx,location,visited);
    }
    return true;
  }
}
