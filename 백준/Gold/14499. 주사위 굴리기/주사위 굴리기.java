import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[] population;
  static int N;
  static int M;
  static int K;
  static int x;
  static int y;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    y = Integer.valueOf(stringTokenizer.nextToken());
    x = Integer.valueOf(stringTokenizer.nextToken());
    K = Integer.valueOf(stringTokenizer.nextToken());
    int[][] map = new int[N][M];
    int[] command = new int[K];
    int[] dice = {0,0,0,0,0,0,0};

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    stringTokenizer = new StringTokenizer(br.readLine());
    for (int i=0; i<K; i++){
      command[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<K; i++){
      int nx = x;
      int ny = y;
      //System.out.println(ny+","+nx+"  "+dice[6]);
      switch (command[i]){
        case 1:
          if (mapInAndOut(nx,ny,1)) {
            int tmp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
          }
          else continue;
          break;
        case 2:
          if (mapInAndOut(nx,ny,2)) {
            int tmp2 = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp2;
          }
          else continue;
          break;
        case 3:
          if (mapInAndOut(nx,ny,3)) {
            int tmp3 = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp3;
          }
          else continue;
          break;
        case 4:
          if (mapInAndOut(nx,ny,4)) {
            int tmp4 = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp4;
          }
          else continue;
          break;
      }

      if (map[y][x]==0){
        map[y][x] = dice[6];
      }
      else {
        dice[6] = map[y][x];
        map[y][x] = 0;
      }
      System.out.println(dice[1]);
    }
  }
  static boolean mapInAndOut(int nx, int ny, int number){
    switch (number){
      case 1:
        nx+=1;
        if (nx>M-1){
          return false;
        }
        x = nx;
        break;
      case 2:
        nx-=1;
        if (nx<0){
          return false;
        }
        x = nx;
        break;
      case 3:
        ny-=1;
        if (ny<0){
          return false;
        }
        y = ny;
        break;
      case 4:
        ny+=1;
        if (ny>N-1){
          return false;
        }
        y = ny;
        break;
    }
    return true;
  }
}