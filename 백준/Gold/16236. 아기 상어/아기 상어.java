import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.management.ObjectName;

public class Main {
  static int[] fish = {0,0,0,0,0,0,0};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[][] map = new int[N][N];
    int[] dx = {0,-1,1,0};
    int[] dy = {-1,0,0,1};
    StringTokenizer stringTokenizer;
    BabyShark babyShark = new BabyShark(0,0,2,0,0);
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[2]==o2[2]){
          if (o1[1]==o2[1]){
            return o1[0]-o2[0];
          }
          return o1[1]-o2[1];
        }
        return o1[2]-o2[2];
      }
    });
    boolean[][] visit = new boolean[N][N];

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        if (map[i][j]==9) {
          map[i][j] = 0;
          babyShark.x = j;
          babyShark.y = i;
        }
        if (map[i][j]==1||map[i][j]==2||map[i][j]==3||map[i][j]==4||map[i][j]==5||map[i][j]==6){
          fish[map[i][j]]++;
        }
      }
    }

    queue.add(new int[]{babyShark.x, babyShark.y, 0});
    visit[babyShark.y][babyShark.x] = true;

    while (!momShark(babyShark.size)) {

      while (!queue.isEmpty()) {
        int x = queue.peek()[0];
        int y = queue.peek()[1];
        int time = queue.peek()[2];

        queue.poll();

        if (babyShark.size > map[y][x] && map[y][x] != 0 && map[y][x]!=9) {
          babyShark.x = x;
          babyShark.y = y;
          babyShark.eat++;
          babyShark.time += time;
          fish[map[y][x]]--;
          map[y][x] = 0;

          if (babyShark.eat == babyShark.size) {
            babyShark.eat = 0;
            babyShark.size++;
          }
          visit = new boolean[N][N];
          queue.clear();
          queue.add(new int[]{babyShark.x, babyShark.y, 0});
          visit[babyShark.y][babyShark.x] = true;
          break;
        }

        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || map[ny][nx] > babyShark.size || visit[ny][nx]) {
            continue;
          }
          visit[ny][nx] = true;
          queue.add(new int[]{nx, ny, time + 1});
        }
      }
      if (queue.isEmpty()){
        break;
      }
    }
    System.out.println(babyShark.time);
  }
  static boolean momShark(int size){
    int sum = 0;
    if (size>6){
      for (int i=1; i<7; i++){
        sum+=fish[i];
      }
    }
    else {
      for (int i = 1; i < size; i++) {
        sum += fish[i];
      }
    }
    if (sum==0){
      return true;
    }
    return false;
  }
  static class BabyShark{
    int x;
    int y;
    int size;
    int eat;
    int time;

    public BabyShark(int x, int y, int size,int eat, int time) {
      this.x = x;
      this.y = y;
      this.size = size;
      this.eat = eat;
      this.time = time;
    }
  }
}