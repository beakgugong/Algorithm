import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  static int N;
  static int M;
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {-1, 0, 1, 0};
  static ArrayList<int[]> cctv = new ArrayList<>();
  static int anwser = Integer.MAX_VALUE;
  static int[][] original;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.valueOf(st.nextToken());
    M = Integer.valueOf(st.nextToken());
    original = new int[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        original[i][j] = Integer.valueOf(st.nextToken());
        if (original[i][j]!=0&&original[i][j]!=6){
          cctv.add(new int[]{i,j});
        }
      }
    }

    dfs(original,0);

    System.out.println(anwser);

  }
  static void dfs(int[][] map, int count){
    if (count== cctv.size()){
      anwser = Math.min(anwser,fourRegion(map));
      return;
    }
    int[][] copy = new int[map.length][map[0].length];


    int y = cctv.get(count)[0];
    int x = cctv.get(count)[1];

    int num = map[y][x];
    Cctv cctv1 = Cctv.of(num);

    for (int i=0; i<4; i++) {
      for (int j=0; j<map.length; j++){
        copy[j] = map[j].clone();
      }

      for (int j = 0; j < cctv1.direction.length; j++) {
        int ny = y;
        int nx = x;
        while (ny >= 0 && nx >= 0 && ny <= N - 1 && nx <= M - 1 && map[ny][nx] != 6) {
          if (map[ny][nx] == 0) {
            copy[ny][nx] = 7;
          }
          ny += dy[(cctv1.direction[j]+i)%4];
          nx += dx[(cctv1.direction[j]+i)%4];
        }
      }
      dfs(copy, count + 1);
    }
  }
  static int fourRegion(int[][] map){
    int count = 0;

    for (int i=0; i< map.length; i++){
      for (int j=0; j<map[i].length; j++){
        if (map[i][j]==0){
          count++;
        }
      }
    }
    return count;
  }
  static class Cctv{
   int[] direction;

   static Cctv of(int number){
     Cctv cctv = new Cctv();
     switch (number){
       case 1:
         cctv.direction = new int[1];
         cctv.direction[0] = 3;
         break;
       case 2:
         cctv.direction = new int[2];
         cctv.direction[0] = 3;
         cctv.direction[1] = 1;
         break;
       case 3:
         cctv.direction = new int[2];
         cctv.direction[0] = 3;
         cctv.direction[1] = 2;
         break;
       case 4:
         cctv.direction = new int[3];
         cctv.direction[0] = 3;
         cctv.direction[1] = 2;
         cctv.direction[2] = 1;
         break;
       case 5:
         cctv.direction = new int[4];
         cctv.direction[0] = 3;
         cctv.direction[1] = 2;
         cctv.direction[2] = 1;
         cctv.direction[3] = 0;
         break;
     }
     return cctv;
   }
  }
}