import java.awt.geom.Area;
import java.io.*;
import java.util.*;
import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (stringTokenizer.hasMoreTokens()){
      arrayList.add(Integer.valueOf(stringTokenizer.nextToken()));
    }

    int[][][] dp = new int[arrayList.size()][5][5];
    for (int i=0; i<arrayList.size(); i++){
      for (int j=0; j<5; j++){
        Arrays.fill(dp[i][j],Integer.MAX_VALUE);
      }
    }

    dp[0][0][0] = 0;
    dp[1][arrayList.get(0)][0] = 2;
    dp[1][0][arrayList.get(0)] = 2;

    for (int i=1; i<arrayList.size(); i++){
      int num = arrayList.get(i-1);
      for (int j=0; j<5; j++){
        for (int k=0; k<5; k++){
          if (dp[i-1][j][k]!=Integer.MAX_VALUE&&(j!=k)){
            dp[i][j][num] =Math.min(dp[i][j][num],dp[i-1][j][k]+move(k,num));
            dp[i][num][k] =Math.min(dp[i][num][k],dp[i-1][j][k]+move(j,num));
          }
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i=0; i<5; i++){
      for (int j=0; j<5; j++){
        min = Math.min(dp[arrayList.size()-1][i][j],min);

      }
    }
    System.out.println(min);
  }
  public static int move(int x, int y) {
    if(x == 0) return 2;
    if(Math.abs(x - y) == 2) return 4;

    if(x == y) return 1;

    else return 3;

  }
}