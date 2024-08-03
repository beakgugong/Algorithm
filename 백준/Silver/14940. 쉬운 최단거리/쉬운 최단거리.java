import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static boolean[][] graph;
  static boolean[] visit;
  static int maxCount;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[][] arr = new int[N][M];
    int[][] answer = new int[N][M];
    int[] start = new int[2];
    int[] dx = {0,-1,0,1};
    int[] dy = {-1,0,1,0};
    Queue<int[]> queue = new LinkedList<>();


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++){
        arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        answer[i][j] = -1;
        if (arr[i][j]==2){
          start = new int[]{i,j};
          answer[i][j] = 0;
        }
        else if (arr[i][j]==0){
          answer[i][j] = 0;
        }
      }
    }

    queue.add(new int[]{start[0],start[1],0});
    while (!queue.isEmpty()){
      int x = queue.peek()[1];
      int y = queue.peek()[0];
      int distance = queue.peek()[2];
      queue.poll();
      for (int i=0; i<4; i++){
        int nx = x+dx[i];
        int ny = y+dy[i];

        if (nx<0||ny<0||nx>M-1||ny>N-1||answer[ny][nx]!=-1){
          continue;
        }
        if (arr[ny][nx]==0){
          answer[ny][nx] = 0;
          continue;
        }
        answer[ny][nx] = distance+1;

        queue.add(new int[]{ny,nx,distance+1});
      }
    }

    for (int i=0; i<answer.length; i++){
      for (int j=0; j<answer[i].length; j++){
        {
          System.out.print(answer[i][j]+" ");
        }
      }
      System.out.println();
    }
  }
}