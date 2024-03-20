import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static int H;
  static int[][] ladder;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    H = Integer.valueOf(stringTokenizer.nextToken());
    ladder = new int[N][H];

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int tmpH = Integer.valueOf(stringTokenizer.nextToken())-1;
      int tmpN = Integer.valueOf(stringTokenizer.nextToken())-1;
      ladder[tmpN][tmpH]=1;
    }

    for (int i=0; i<=3; i++){
      dfs(i,0, 0);
    }
    System.out.println("-1");
  }
  static void dfs(int i, int count,int next){
    if (count==i){
      if (check()){
        System.out.println(i);
        System.exit(0);
      }
      return;
    }

    for (int k=0; k<N; k++){
      for (int j=next; j<H; j++){
        if (ladder[k][j]==1){
          continue;
        }
        if (k!=N-1&&ladder[k+1][j]==1){
          continue;
        }
        if (k!=0&&ladder[k-1][j]==1){
          continue;
        }
        ladder[k][j]=1;
        dfs(i,count+1,j);
        ladder[k][j] = 0;
      }
    }
  }
  static boolean check(){
    for (int i=0; i<N; i++){
      int location = i;
      int start = 0;
      while (start<H){
        if (location!=N-1&&ladder[location][start]==1){
          location++;
          start++;
        }
        else if(location!=0&&ladder[location-1][start]==1){
          location--;
          start++;
        }
        else start++;
      }
      if (location!=i)return false;
    }
    return true;
  }
}