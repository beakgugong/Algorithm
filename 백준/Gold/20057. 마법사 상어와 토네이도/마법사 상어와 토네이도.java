import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N,count;
  static int[][] map;
  static int dsx[][] = {{-1,1,-2,2,0,-1,1,-1,1,0},{-1,-1,0,0,2,0,0,1,1,1},
          {-1,1,-2,2,0,-1,1,-1,1,0},{1,1,0,0,-2,0,0,-1,-1,-1}};
  static int dsy[][] = {{1,1,0,0,-2,0,0,-1,-1,-1}, {-1,1,-2,2,0,-1,1,-1,1,0},
          {-1,-1,0,0,2,0,0,1,1,1}, {-1,1,-2,2,0,-1,1,-1,1,0}};
  static int[] dx = {0,1,0,-1};
  static int[] dy = {-1,0,1,0};
  static int rate[] = {1,1,2,2,5,7,7,10,10};
  static int[] direction = {0,1,2,3};
  static int outSand = 0;
  static Tornado tornado;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][N];
    tornado = new Tornado(N/2,N/2,0);
    count=0;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i=1; i<N; i++){
      if (i!=N-1){
        for (int j=0; j<2; j++){
          calculate(i);
        }
      }
      else {
          for (int j=0; j<3; j++){
            calculate(i);
        }
      }
    }

    System.out.println(outSand);
  }
  static void calculate(int i){
    for (int k=0; k<i; k++){
      tornado.x+=dx[count];
      tornado.y+=dy[count];
      int rateSand = 0;
      for (int l=0; l<10; l++){
        int nsx = tornado.x+dsx[count][l];
        int nsy = tornado.y+dsy[count][l];

        if (nsx<0||nsy<0|nsx>N-1||nsy>N-1) {
          if (l==9){
            outSand += map[tornado.x][tornado.y]-rateSand;
            break;
          }else {
            outSand += rate[l]*map[tornado.x][tornado.y]/100;
          }
        }
        else {
          if (l==9){
            map[nsx][nsy] += map[tornado.x][tornado.y]-rateSand;
            break;
          }else {
            map[nsx][nsy] += rate[l] * map[tornado.x][tornado.y]/100;
          }
        }
        rateSand+=rate[l] * map[tornado.x][tornado.y]/100;
      }
    }
    count++;
    count%=4;
  }
  static class Tornado{
    int x;
    int y;
    int direction;

    public Tornado(int x, int y, int direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }
  }
}