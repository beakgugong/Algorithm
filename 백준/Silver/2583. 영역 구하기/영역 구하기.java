import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};
  static int N;
  static int M;
  static int count;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    M = Integer.valueOf(stringTokenizer.nextToken());
    N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    int[][] location = new int[M][N];
    int answer = 0;
    ArrayList<Integer> width = new ArrayList<>();
    count = 0;

    while (br.ready()){
      stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());
      int x2 = Integer.valueOf(stringTokenizer.nextToken());
      int y2 = Integer.valueOf(stringTokenizer.nextToken());
      for (int i=y; i<y2; i++){
        for (int j=x; j<x2; j++){
          location[i][j]=1;
        }
      }
    }
    for (int y=0; y<M; y++){
      for (int x=0; x<N; x++){
        if(dfs(x,y,location)){
          width.add(count);
          answer++;
          count=0;
        }
      }
    }
    System.out.println(answer);
    Collections.sort(width);
    for (int i=0; i<width.size(); i++){
      System.out.print(width.get(i)+" ");
    }
  }
  public static boolean dfs(int x, int y, int[][] location){
    if(x<0 || y<0 || x>N-1 || y >M-1 || location[y][x]!=0){
      return false;
    }
    location[y][x] = 1;
    for(int i=0; i<4; i++){
      int nx = x+dx[i];
      int ny = y+dy[i];
      dfs(nx,ny,location);
    }
    count++;
    return true;
  }
}