import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int D;
  static int[][] map;
  static int one;
  static boolean[] bow;
  static int answer = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    D = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][M];
    bow = new boolean[M];

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        if (map[i][j]==1){
          one++;
        }
      }
    }
    dfs(0);

    System.out.println(answer);


  }
  static void dfs(int bowCount){
    if (bowCount==3){
      calculate();
      return;
    }

    for (int i=0; i<M; i++){
      if (bow[i]){
        continue;
      }
      bow[i] = true;
      dfs(bowCount+1);
      bow[i] = false;
    }
  }

  private static void calculate() {
    int[][] copy = new int[N][M];
    int oneCopy = one;
    int tmp = 0;
    Queue<int[]> queue = new LinkedList<>();

    for (int i=0; i<N; i++){
      copy[i] = map[i].clone();
    }

    while (oneCopy>0){
      for (int i=0; i<M; i++){
        if (bow[i]){
          int d = Integer.MAX_VALUE;
          int y = -1;
          int x = -1;

          for (int k=0; k<M; k++){
          for (int j=N-1; j>=0; j--){
              if (copy[j][k]==1&& d>Math.abs(k-i)+N-j){

                d = Math.abs(k-i)+N-j;
                y = j;
                x = k;
              }
            }
          }
          if ((y!=-1&&x!=-1)&&d<=D){
            queue.add(new int[]{y,x});
          }
        }
      }

      while (!queue.isEmpty()){
        int y = queue.peek()[0];
        int x = queue.peek()[1];
        queue.poll();
        if (copy[y][x]==1) {
          copy[y][x] = 0;
          oneCopy--;
          tmp++;
        }
      }
      oneCopy-=moveEnemy(copy);
    }

    answer = Math.max(answer,tmp);
  }
  private static int moveEnemy(int[][] copy){
    int one = 0;
    for (int i=0; i<M; i++){
      if (copy[N-1][i]==1){
        one++;
      }
    }
    for (int i=N-1; i>0; i--){
      copy[i] = copy[i-1].clone();
    }
    for (int i=0; i<M; i++){
      copy[0][i] = 0;
    }
    return one;
  }
}