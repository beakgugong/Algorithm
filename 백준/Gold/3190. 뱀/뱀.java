import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int apple;
  static int direction;
  static boolean[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    apple = Integer.valueOf(br.readLine());
    int[][] map = new int[N][N];
    visit = new boolean[N][N];
    char[] turn = new char[10000];
    Queue<int[]> record = new LinkedList<>();
    StringTokenizer stringTokenizer;

    for (int i=0; i<apple; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int y = Integer.valueOf(stringTokenizer.nextToken())-1;
      int x = Integer.valueOf(stringTokenizer.nextToken())-1;
      map[y][x] = 1;
      }

    int L = Integer.valueOf(br.readLine());

    for (int i=0; i<L; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int time = Integer.valueOf(stringTokenizer.nextToken());
      char direction = stringTokenizer.nextToken().charAt(0);
      turn[time] = direction;
    }

    int[] current = {0,0};
    record.add(new int[]{0,0});
    int second = 0;
    direction = 0;

    while (true){

      if (turn[second]>0) {
        if (turn[second] == 'D') {
          direction += 1;
        } else
          direction -= 1;
        if (direction > 3) {
          direction = 0;
        } else if (direction < 0) {
          direction = 3;
        }
      }

      switch (direction) {
          case 0:
            current[1]+=1;
            break;
          case 1:
            current[0]+=1;
            break;
          case 2:
            current[1]-=1;
            break;
          case 3:
            current[0]-=1;
            break;
      }
      second++;
      int x = current[1];
      int y = current[0];
      if (x<0||y<0||x>N-1||y>N-1||visit[y][x]){
        break;
      }
      record.add(new int[]{y,x});
      if (map[y][x]==0){
        visit[record.peek()[0]][record.peek()[1]] = false;
        record.poll();
      }
      else {
        map[y][x] = 0;
      }
      visit[y][x] = true;
    }
    System.out.println(second);
  }
}