import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[][] A;
  static int[] dy = {0,-1,-1,-1,0,1,1,1};
  static int[] dx = {-1,-1,0,1,1,1,0,-1};
  static boolean[][] visit;
  static List<Cloud> list;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    A = new int[N][N];
    visit = new boolean[N][N];
    int[][] command = new int[M][2];
    list = new ArrayList<>();

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        A[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      command[i][0] = Integer.valueOf(stringTokenizer.nextToken())-1;
      command[i][1] = Integer.valueOf(stringTokenizer.nextToken());
    }
    Cloud cloud1 = new Cloud(N-1, 0);
    Cloud cloud2 = new Cloud(N-1, 1);
    Cloud cloud3 = new Cloud(N-2, 0);
    Cloud cloud4 = new Cloud(N-2, 1);
    list.add(cloud1);
    list.add(cloud2);
    list.add(cloud3);
    list.add(cloud4);

    for (int i=0; i<command.length; i++){
      moveCloud(command[i][0],command[i][1]);
      rainy();
      duplicateWater();
      generateCloud();
      visit = new boolean[N][N];
    }

    int answer = 0;
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        answer += A[i][j];
      }
    }
    System.out.println(answer);
  }
  static void moveCloud(int d, int i){
    for (Cloud c : list){
      int x = c.x+(dx[d]*i);
      int y = c.y+(dy[d]*i);
      x %= N;
      y %= N;

      if (x<0){
        x+=N;
      }
      if (y<0) {
        y+=N;
      }
      c.x = x;
      c.y = y;
    }
  }
  static void rainy(){
    for (Cloud c : list){
      A[c.y][c.x]++;
      c.locationCheck();
    }
  }
  static void duplicateWater(){
    for (Cloud c : list){
      int x = c.x;
      int y = c.y;
      int count = 0;

      for (int i=1; i<8; i+=2){
        int nx = x+dx[i];
        int ny = y+dy[i];

        if (nx<0||ny<0||nx>N-1||ny>N-1){
          continue;
        }
        if (A[ny][nx]>0){
          count++;
        }
      }
      A[y][x] += count;
    }
    list.clear();
  }
  static void generateCloud(){
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        if (A[i][j]>1&&!visit[i][j]){
          Cloud cloud = new Cloud(i,j);
          list.add(cloud);
          A[i][j] -= 2;
        }
      }
    }
  }
  static class Cloud{
    int y;
    int x;

    public Cloud(int y, int x) {
      this.y = y;
      this.x = x;
    }
    void locationCheck(){
      visit[this.y][this.x] = true;
    }
  }
}