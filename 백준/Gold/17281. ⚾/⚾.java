import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int max;
  static boolean[] visit;
  static int[][] player;
  static boolean[] mound;
  static int[] sequence = new int[9]; ;
  static int answer;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    player = new int[N][9];
    answer = 0;
    max = Integer.MIN_VALUE;
    mound = new boolean[4];
    visit = new boolean[9];


    for (int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j=0; j<9; j++){
        player[i][j] = Integer.valueOf(st.nextToken());
      }
    }
    visit[3] = true;
    sequence[3] = 0;
    dfs(1);
    System.out.println(answer);
  }
  static void dfs(int count){
    if (count==9){
      answer = Math.max(calculate(),answer);
      return;
    }
    for (int i=0; i<9; i++){
      if (visit[i]){
        continue;
      }
      visit[i] = true;
      sequence[i] = count;
      dfs(count+1);
      visit[i] = false;
    }
  }
  static int calculate(){
    int score = 0;
    int start = 0;
    for (int j=0; j<N; j++) {
      int out = 0;
      mound = new boolean[4];

      while (true) {
        if (start>8){
          start=0;
        }
        int homeRun = player[j][sequence[start]];
        mound[0] = true;
        if (homeRun==0){
          out++;
          start++;
          if (out==3) {
            break;
          }
          continue;
        }

        if (homeRun == 4) {
          for (int i = 3; i > 0; i--) {
            if (mound[i]) {
              score++;
              mound[i] = false;
            }
          }
          score++;
        } else if (homeRun == 1) {
          for (int i = 3; i >= 0; i--) {
            if (mound[i] && i == 3) {
              score++;
              mound[i] = false;
            } else if (mound[i]) {
              mound[i + 1] = true;
              mound[i] = false;
            }
          }
        } else if (homeRun == 2) {
          for (int i = 3; i >= 0; i--) {
            if (mound[i] && (i == 3 || i == 2)) {
              score++;
              mound[i] =false;
            } else if (mound[i]) {
              mound[i + 2] = true;
              mound[i] = false;
            }
          }
        } else if (homeRun == 3) {
          for (int i = 3; i >= 0; i--) {
            if (mound[i] && (i == 3 || i == 2 || i == 1)) {
              score++;
              mound[i] = false;
            } else if (mound[i]){
              mound[3] = true;
            }
          }
        }
        start++;
      }
    }
    return score;
  }
}