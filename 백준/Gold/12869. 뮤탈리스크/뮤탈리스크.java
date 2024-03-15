import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
  static int[][] attack = {{1,3,9},{1,9,3},{3,1,9},{3,9,1},{9,1,3},{9,3,1}};
  static int[][][] dp = new int[61][61][61];
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(bufferedReader.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int[] array = new int[3];


    for (int i=0; i<N; i++){
      array[i]=Integer.valueOf(stringTokenizer.nextToken());
    }
    dfs(array, 0);
    System.out.println(min);
  }
  static void dfs(int[] array, int count){
    if (min<=count)return;
    if(dp[array[0]][array[1]][array[2]] != 0 && dp[array[0]][array[1]][array[2]] <= count) return;
    dp[array[0]][array[1]][array[2]] = count;

    if(array[0] == 0 && array[1] == 0 && array[2] == 0) {
      min = Math.min(min, count);
      return;
    }

    for(int i=0; i<6; i++) {
      dfs(new int[]{Math.max(array[0]-attack[i][0], 0),Math.max(array[1]-attack[i][1], 0),Math.max(array[2]-attack[i][2], 0)},count+1);
    }
  }
}