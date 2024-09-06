import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N= Integer.valueOf(br.readLine());
    int count = 1;

    while (N!=0){
      int[][] arr = new int[N][N];
      StringTokenizer stringTokenizer;
      for (int i=0; i<N; i++){
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int j=0; j<N; j++){
          arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        }
      }
      System.out.println("Problem "+count+": "+bfs(arr,N));
      N = Integer.valueOf(br.readLine());
      count++;
    }

  }
  static int bfs(int[][] arr, int n){
    boolean[][] visit = new boolean[n][n];
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2]-o2[2];
      }
    });

    int[] dx = {0,-1,0,1};
    int[] dy = {1,0,-1,0};
    int[][] minValue = new int[n][n];
    queue.add(new int[]{0,0,arr[0][0]});
    visit[0][0] = true;


    for (int i =0; i<n; i++){
      Arrays.fill(minValue[0],Integer.MAX_VALUE);
    }

    while (!queue.isEmpty()){
      int[] tmp = queue.poll();
      int x = tmp[0];
      int y = tmp[1];
      int money = tmp[2];

      if (x==n-1&&y==n-1){
        return money;
      }
      for (int i=0; i<4; i++){
        int nx = x+dx[i];
        int ny = y+dy[i];

        if (nx<0||ny<0||nx>n-1||ny>n-1||visit[ny][nx]){
          continue;
        }
        queue.add(new int[]{nx, ny, arr[ny][nx]+money});
        visit[ny][nx] = true;
      }
    }
    return arr[n-1][n-1];
  }
}