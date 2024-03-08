import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int N;
  static int M;
  static int count;
  static Queue<int[]> queue = new LinkedList<>();
  static int[][] visited;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    arr = new int[N][M];
    visited = new int[N][M];



    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for(int j=0; j<M; j++){
        arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }
    int time = 0;

    while (true){
      dfs(0,0);
      time++;
      addCheese();
      if (extraCheese()==0){
        break;
      }
    }

    System.out.println(time);
    System.out.println(count);
    }
    static int extraCheese(){
      int num = 0;

      for (int i=0; i<N; i++){
        for (int j=0; j<M; j++){
          visited[i][j]=0;
          if (arr[i][j]==1){
            num++;
          }
        }
      }
      return num;
    }
    static void dfs(int y, int x){
      visited[y][x]=1;
      if(arr[y][x]==1){
        queue.add(new int[]{y,x});
        return;
      }
        for(int i=0; i<4; i++){
          int ny = dy[i]+y;
          int nx = dx[i]+x;

          if(ny<0||nx<0||ny>N-1||nx>M-1||visited[ny][nx]==1){
            continue;
          }
          dfs(ny,nx);
        }
    }
    static void addCheese(){
      count=0;
      while (queue.size()!=0) {
        int[] tmp = queue.poll();
        arr[tmp[0]][tmp[1]] = 0;
        count++;
      }
    }
  }