import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M, K;
  static int[][] A;
  static int[][] map;
  static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
  static Queue<Tree>  queue = new LinkedList<>();


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    K = Integer.valueOf(stringTokenizer.nextToken());
    A = new int[N+1][N+1];
    map = new int[N+1][N+1];

    for (int i=1; i<N+1; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=1; j<N+1; j++) {
        A[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        map[i][j] = 5;
      }
    }

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());
      int z = Integer.valueOf(stringTokenizer.nextToken());
      queue.add(new Tree(x,y,z));
    }

    Collections.sort((List<Tree>) queue);

    while (K>0){
      springAndSummer();
      fall();
      winter();
      K--;
    }

    System.out.println(queue.size());
  }

  static void springAndSummer(){

    int[][] tmp = new int[N+1][N+1];
    int len = queue.size();

    for (int i=0; i<len; i++){
      Tree t = queue.poll();

      if (map[t.x][t.y] >= t.old){
        map[t.x][t.y] -= t.old;
        queue.add(new Tree(t.x,t.y,t.old+1));
      }
      else {
        tmp[t.x][t.y] += t.old/2;
      }
    }
    for (int i=1; i<N+1; i++){
      for (int j=1; j<N+1; j++){
        map[i][j] += tmp[i][j];
      }
    }
  }
  static void fall(){
    int len = queue.size();
    ArrayList<Tree> tmp = new ArrayList<>();

    for (int j=0; j<len; j++){
      Tree t = queue.poll();
      tmp.add(t);
      if ((t.old%5)==0){
        for (int i=0; i<8; i++){
          int nx = t.x+dx[i];
          int ny = t.y+dy[i];

          if (nx<1||ny<1||nx>N||ny>N) {
            continue;
          }
          queue.add(new Tree(nx,ny,1));

        }
      }
    }

    for (Tree tree :tmp){
      queue.add(tree);
    }

  }
  static void winter(){
    for (int i=1; i<N+1; i++){
      for (int j=1; j<N+1; j++){
        map[i][j]+=A[i][j];
      }
    }
  }
  static class Tree implements Comparable<Tree> {
    int x;
    int y;
    int old;

    public Tree(int x, int y, int old) {
      this.x = x;
      this.y = y;
      this.old = old;
    }

    @Override
    public int compareTo(Tree o) {
      return this.old-o.old;
    }
  }
}