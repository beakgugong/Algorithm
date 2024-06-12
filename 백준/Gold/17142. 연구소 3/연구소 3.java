import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[][] map;
  static ArrayList<int[]> virusLocation;
  static ArrayList<int[]> activeVirus;
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][N];
    virusLocation = new ArrayList<>();
    activeVirus = new ArrayList<>();

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        if (map[i][j]==2){
          virusLocation.add(new int[]{i,j});
        }
      }
    }

    dfs(0,0);

    if (answer==Integer.MAX_VALUE){
      System.out.println(-1);
      return;
    }
    System.out.println(answer);
  }
  static void dfs(int start, int count){
    if (count==M){
      bfs();
      return;
    }

    for (int i=start; i<virusLocation.size(); i++){
      int[] tmp = {virusLocation.get(i)[0],virusLocation.get(i)[1]};
      activeVirus.add(tmp);
      dfs(i+1,count+1);
      activeVirus.remove(tmp);
    }
  }
  static void bfs(){
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visit = new boolean[N][N];
    int[][] copyMap = new int[N][N];
    int max = 0;

    for (int i=0; i<N; i++){
      copyMap[i] = map[i].clone();
    }

    for (int i=0; i<activeVirus.size(); i++){
      queue.add(new int[]{activeVirus.get(i)[0],activeVirus.get(i)[1],0});
      visit[activeVirus.get(i)[0]][activeVirus.get(i)[1]] = true;
      copyMap[activeVirus.get(i)[0]][activeVirus.get(i)[1]] = -1;
    }

    while (!queue.isEmpty()){
      int x = queue.peek()[1];
      int y = queue.peek()[0];
      int time = queue.peek()[2];
      queue.poll();

      for (int i=0; i<4; i++){
        int nx = x+dx[i];
        int ny = y+dy[i];

        fillVirus(copyMap, max);
        if (nx<0||ny<0||nx>N-1||ny>N-1||visit[ny][nx]||map[ny][nx]==1){
          continue;
        }
        
        visit[ny][nx] = true;
        copyMap[ny][nx] = -1;
        queue.add(new int[]{ny,nx,time+1});
        max = Math.max(max,time+1);
      }

    }
  }

  private static void fillVirus(int[][] copyMap, int max) {

    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        if (copyMap[i][j]==0){
          return;
        }
      }
    }
   answer = Math.min(answer, max);
  }
}