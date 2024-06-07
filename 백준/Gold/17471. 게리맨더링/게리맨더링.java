import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Main {
  static int[] population;
  static boolean[][] location;
  static int N;
  static boolean[] visit;
  static int[] check;
  static int sum;
  static int min = Integer.MAX_VALUE;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    population = new int[N + 1];
    location = new boolean[N + 1][N + 1];
    visit = new boolean[N + 1];
    check = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      population[i + 1] = Integer.valueOf(st.nextToken());
      sum += population[i + 1];
      check[i + 1] = i + 1;
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int number = Integer.valueOf(st.nextToken());

      for (int j = 0; j < number; j++) {
        int connect = Integer.valueOf(st.nextToken());
        location[i + 1][connect] = true;
      }
    }
    dfs(0,0);

    if (min==Integer.MAX_VALUE){
      System.out.println(-1);
      return;
    }
    System.out.println(min);
  }

  static void dfs(int count, int tmp) {
    if (count == N) {
      return;
    }
    if (connectExistence(count)&&count!=0) {
      min = Math.min(Math.abs(tmp - (sum - tmp)), min);

    }
    for (int i = 1; i < N + 1; i++) {
      if (visit[i]||count>=i) {
        continue;
      }
      visit[i] = true;
      dfs(count + 1, tmp + population[i]);
      visit[i] = false;
    }
  }

  static boolean connectExistence(int count) {
    boolean[] tmpVisit = new boolean[N + 1];
    int locationCount = 0;
    int visitFlag = 0;
    int unvisitFlag = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i < N + 1; i++) {
      if (visit[i]&&visitFlag!=1) {
        queue.add(i);
        locationCount++;
        tmpVisit[i] = true;
        while (!queue.isEmpty()) {
          int number = queue.poll();

          for (int j = 1; j < N + 1; j++) {
            if (!visit[j] || tmpVisit[j] || !location[number][j]) {
              continue;
            }
            queue.add(j);
            tmpVisit[j] = true;
            locationCount++;
          }
        }
        if (count != locationCount) {
          return false;
        }
        locationCount = 0;
        tmpVisit = new boolean[N + 1];
        visitFlag = 1;
      }
      else if (!visit[i]&&unvisitFlag!=1){
          queue.add(i);
          locationCount++;
          tmpVisit[i] = true;
          while (!queue.isEmpty()) {
            int number = queue.poll();

            for (int j = 1; j < N + 1; j++) {
              if (visit[j] || tmpVisit[j] || !location[number][j]) {
                continue;
              }
              queue.add(j);
              tmpVisit[j] = true;
              locationCount++;
            }
          }
          if (N - count != locationCount) {
            return false;
          }
          locationCount = 0;
          tmpVisit = new boolean[N + 1];
          unvisitFlag = 1;
      }
      if (visitFlag==1&&unvisitFlag==1){
        break;
      }
    }
    return true;
  }
}