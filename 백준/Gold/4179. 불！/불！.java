import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static boolean[][] visited;
  static boolean[][] jiVisited;
  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int R = Integer.valueOf(stringTokenizer.nextToken());
    int C = Integer.valueOf(stringTokenizer.nextToken());
    map = new char[R][C];
    visited = new boolean[R][C];
    jiVisited = new boolean[R][C];
    Queue<int[]> fire = new LinkedList<>();
    Queue<int[]> ji = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String str = bufferedReader.readLine();
      for (int j = 0; j < C; j++) {
        if (str.charAt(j) == 'F') {
          fire.add(new int[]{i, j});
          visited[i][j] = true;
        } else if (str.charAt(j) == 'J') {
            if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
              System.out.println(1);
              return;
            }
            ji.add(new int[]{i, j});
        }
        map[i][j] = str.charAt(j);
      }
    }

    int count = 1;
    int current = fire.size();
    int step = 1;

    while (true) {
      for (int k = 0; k < current; k++) {
        int[] tmp = fire.poll();

        for (int i = 0; i < 4; i++) {
          int nx = tmp[1] + dx[i];
          int ny = tmp[0] + dy[i];

          if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1 || map[ny][nx] == '#') {
            continue;
          }
          if (visited[ny][nx] == true) {
            continue;
          }
          visited[ny][nx] = true;
          fire.add(new int[]{ny, nx});
          map[ny][nx] = 'F';
        }
      }
      current = fire.size();

      for (int k = 0; k < step; k++) {
        int[] location = ji.poll();
        for (int i = 0; i < 4; i++) {
          int nx = location[1] + dx[i];
          int ny = location[0] + dy[i];

          if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1 || map[ny][nx] == '#') {
            continue;
          }
          if (map[ny][nx] == 'F'||jiVisited[ny][nx]==true) {
            continue;
          }
          if (ny == 0 || nx == 0 || ny == R - 1 || nx == C - 1) {
            System.out.println(count + 1);
            return;
          }
          jiVisited[ny][nx] = true;
          ji.add(new int[]{ny, nx});
        }
        if (ji.size() == 0) {
          System.out.println("IMPOSSIBLE");
          return;
        }
      }
      step = ji.size();

      count++;
      }
    }
}