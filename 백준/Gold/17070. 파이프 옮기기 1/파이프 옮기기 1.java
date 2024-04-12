import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] arr;
  static int[] dx = {1,0,1};
  static int[] dy = {0,1,1};
  static int answer = 0;
  static final int WIDTH = 0;
  static final int HEIGHT = 1;
  static final int CROSS = 2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    arr = new int[N][N];
    StringTokenizer stringTokenizer;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    dfs(1,0,0);

    System.out.println(answer);
  }
  static void dfs(int x, int y, int state){
    if (x==N-1&&y==N-1){
      answer++;
      return;
    }

    for (int i=0; i<3; i++){
      if (state==0&&i==1){
        continue;
      }
      else if (state==1&&i==0){
        continue;
      }
      int nx = dx[i]+x;
      int ny = dy[i]+y;

      if (nx<0||ny<0||nx>N-1||ny>N-1||arr[ny][nx]==1){
        continue;
      }
      else if (i==2&&arr[ny-1][nx]==1||i==2&&arr[ny][nx-1]==1) {
        continue;
      }

      dfs(nx,ny,i);
    }
  }
}