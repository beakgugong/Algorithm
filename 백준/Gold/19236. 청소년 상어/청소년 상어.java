import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
  static int ans = 0;
  static final int SHARK = 20, BLANK = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] map = new int[4][4];
    int[][] loc = new int[21][2];
    int[] dir = new int[21];
    boolean[] isDead = new boolean[21];
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num;
        loc[num][0] = i;
        loc[num][1] = j;
        dir[num] = Integer.parseInt(st.nextToken())-1;
      }
    }

    int first = map[0][0];
    isDead[first] = true;
    map[0][0] = SHARK;
    loc[SHARK][0] = loc[first][0];
    loc[SHARK][1] = loc[first][1];
    dir[SHARK] = dir[first];
    simulation(first, map, loc, dir, isDead);
    System.out.println(ans);
  }

  static void simulation(int temp, int[][] map, int[][] loc, int[] dir, boolean[] isDead) {
    int sR = loc[SHARK][0], sC = loc[SHARK][1], sDir = dir[SHARK];

    for (int i = 1; i <= 16; i++) {
      if (isDead[i]) continue;

      int r = loc[i][0], c = loc[i][1];
      int nr = r + dx[dir[i]], nc = c + dy[dir[i]];
      while (!isIn(nr, nc) || map[nr][nc] > 16) {
        dir[i] = (dir[i] + 1) % 8;
        nr = r + dx[dir[i]];
        nc = c + dy[dir[i]];
      }

      if (map[nr][nc] == 0) {
        map[r][c] = 0;
        map[nr][nc] = i;
        loc[i][0] = nr;
        loc[i][1] = nc;
      }

      else {
        int fish = map[nr][nc];
        map[r][c] = fish;
        map[nr][nc] = i;
        loc[i][0] = nr;
        loc[i][1] = nc;
        loc[fish][0] = r;
        loc[fish][1] = c;
      }
    }


    for (int i = 1; i < 4; i++) {

      int nr = sR + i*dx[sDir], nc = sC + i*dy[sDir];
      if (!isIn(nr, nc)) break;
      if (map[nr][nc] == BLANK) continue;
      int fish = map[nr][nc];


      isDead[fish] = true;
      dir[SHARK] = dir[fish];
      loc[SHARK][0] = nr;
      loc[SHARK][1] = nc;
      map[sR][sC] = 0;
      map[nr][nc] = SHARK;


      int[][] copyMap = new int[4][4];
      int[][] copyLoc = new int[21][2];
      int[] copyDir = new int[21];
      boolean[] copyIsDead = new boolean[21];
      for (int x = 0; x < 4; x++) {
        for (int y = 0; y < 4; y++) {
          copyMap[x][y] = map[x][y];
        }
      }
      for (int x = 0; x < 21; x++) {
        copyDir[x] = dir[x];
        copyIsDead[x] = isDead[x];
        for (int y = 0; y < 2; y++) {
          copyLoc[x][y] = loc[x][y];
        }
      }
      simulation(temp + fish, copyMap, copyLoc, copyDir, copyIsDead);


      isDead[fish] = false;
      dir[SHARK] = sDir;
      loc[SHARK][0] = sR;
      loc[SHARK][1] = sC;
      map[sR][sC] = SHARK;
      map[nr][nc] = fish;
    }
    ans = Math.max(ans, temp);
  }

  static boolean isIn(int r, int c) {
    return (r >= 0 && r < 4 && c >= 0 && c < 4);
  }
}