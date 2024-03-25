import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int R;
  static int C;
  static int T;
  static int[][] map;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};
  static int[][] calculate;
  static int[] up = new int[2];
  static int[] down = new int[2];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    R = Integer.valueOf(stringTokenizer.nextToken());
    C = Integer.valueOf(stringTokenizer.nextToken());
    T = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[R][C];
    calculate = new int[R][C];
    int flag = 0;

    for (int i = 0; i < R; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        if (map[i][j] == -1 && flag == 0) {
          up[0] = j;
          up[1] = i;
          flag = 1;
        } else if (map[i][j] == -1) {
          down[0] = j;
          down[1] = i;
        }
      }
    }

    int time = 0;
    while (time < T) {
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (map[i][j] > 0) {
            int tmp = map[i][j] / 5;
            int count = 0;
            for (int k = 0; k < 4; k++) {
              int nx = dx[k] + j;
              int ny = dy[k] + i;
              if (nx < 0 || ny < 0 || ny > R - 1 || nx > C - 1 || map[ny][nx] == -1) {
                continue;
              }
              count++;
            }
            calculate[i][j] = tmp;
            map[i][j] -= tmp * count;
          }
        }
      }

      nextTime();
      airUpClean();
      airDownClean();
      time++;
      
    }
    int answer = 0;
    for (int i =0; i<R; i++){
      for (int j=0; j<C; j++){
        if (map[i][j]>0){
          answer+=map[i][j];
        }
      }
    }
    System.out.println(answer);
  }
  static void nextTime(){
    for (int i=0; i<R; i++){
      for (int j=0; j<C; j++){
        if (calculate[i][j]>0){
          for (int k=0; k<4; k++){
              int nx = dx[k]+j;
              int ny = dy[k]+i;
              if (nx<0||ny<0||ny>R-1||nx>C-1||map[ny][nx]==-1){
                continue;
              }
              map[ny][nx] += calculate[i][j];
          }
        }
        calculate[i][j]=0;
      }
    }
  }
  static void airUpClean(){
    int startx = up[0];
    int starty = up[1];
    for (int i=startx-2; i>-1; i--){
      map[starty][i+1] = map[starty][i];
    }
    for (int i=starty-2; i>=0; i--){
      map[i+1][up[0]] = map[i][up[0]];
    }
    for (int i=0; i<C-1; i++){
      map[0][i] = map[0][i+1];
    }
    for (int i=1; i<starty+1; i++){
      map[i-1][C-1] = map[i][C-1];
    }
    for (int i=C-1; i>startx; i--){
      map[starty][i] = map[starty][i-1];
    }
    map[starty][startx+1] = 0;
  }
  static void airDownClean(){
    int startx = down[0];
    int starty = down[1];
    for (int i=startx-1; i>0; i--){
      map[starty][i] = map[starty][i-1];
    }
    for (int i=starty+1; i<R-1; i++){
      map[i][0] = map[i+1][0];
    }
    for (int i=0; i<C-1; i++){
      map[R-1][i] = map[R-1][i+1];
    }
    for (int i=R-1; i>starty-1; i--){
      map[i][C-1] = map[i-1][C-1];
    }
    for (int i=C-1; i>startx; i--){
      map[starty][i] = map[starty][i-1];
    }

    map[starty][startx+1] = 0;

  }
}