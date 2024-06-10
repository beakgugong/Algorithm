import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int N;
  static int L;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    L = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][N];
    boolean[] visit;
    int answer = 0;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    for (int i=0; i<N; i++){
      int tmp = map[i][0];
      boolean flag = true;
      visit = new boolean[N];

      for (int j=0; j<N; j++){
        if (tmp!=map[i][j]) {
          if (Math.abs(tmp - map[i][j]) > 1) {
            flag = false;
            break;
          } else if (tmp < map[i][j]) {
            for (int k = 1; k < L+1; k++) {
              if (visit[j-k]||j - L < 0 || Math.abs(map[i][j]-map[i][j - k])!=1) {
                flag = false;
                break;
              }
              visit[j-k] = true;
            }
          } else if (tmp > map[i][j]) {
            for (int k = 0; k < L; k++) {
              if (visit[j+k]||j + L > N || map[i][j] != map[i][j + k]) {
                flag = false;
                break;
              }
              visit[j+k] = true;
            }
          }
        }
        tmp = map[i][j];
        if (!flag){
          break;
        }
      }
      if (flag)answer++;


      tmp = map[0][i];
      flag = true;
      visit = new boolean[N];
      for (int j=0; j<N; j++){
        if (tmp!=map[j][i]) {
          if (Math.abs(tmp - map[j][i]) > 1) {
            flag = false;
            break;
          } else if (tmp < map[j][i]) {
            for (int k = 1; k < L+1; k++) {
              if (visit[j-k]||j - L < 0 || Math.abs(map[j][i]-map[j-k][i])!=1) {
                flag = false;
                break;
              }
              visit[j-k] = true;
            }
          } else if (tmp > map[j][i]) {
            for (int k = 0; k < L; k++) {
              if (visit[j+k]||j + L > N || map[j][i] != map[j+k][i]) {
                flag = false;
                break;
              }
              visit[j+k] = true;
            }
          }
        }
        tmp = map[j][i];
        if (!flag){
          break;
        }
      }
      if (flag)answer++;
    }
    System.out.println(answer);
  }
}