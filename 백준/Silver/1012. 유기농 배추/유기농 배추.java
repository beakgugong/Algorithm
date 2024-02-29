import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(br.readLine());


    for(int i=0; i<n; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      int M = Integer.valueOf(stringTokenizer.nextToken());
      int N = Integer.valueOf(stringTokenizer.nextToken());
      int k = Integer.valueOf(stringTokenizer.nextToken());
      int[][] baechu = new int[N][M];
      int answer = 0;

      for (int j=0; j<k; j++) {
        stringTokenizer = new StringTokenizer(br.readLine());
        int x = Integer.valueOf(stringTokenizer.nextToken());
        int y = Integer.valueOf(stringTokenizer.nextToken());

        baechu[y][x] = 1;
      }
      for (int j=0; j<N; j++){
        for(int z=0; z<M; z++){
          if(dfs(z,j,baechu,N,M)){
            answer++;
          }
        }
      }
      System.out.println(answer);
    }



  }
  public static boolean dfs(int x, int y, int[][] beachu, int N, int M){
    if(x<0 || y<0 || x>M-1 || y>N-1 || beachu[y][x]==0){
      return false;
    }

    for(int i=0; i<4; i++){
      int nx = x+dx[i];
      int ny = y+dy[i];
      beachu[y][x] = 0;
      dfs(nx,ny,beachu,N,M);
    }
    return true;
  }
}
