import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

class Main {
  static int[][] coins;
  static int[] answer = new int[3];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;

    for (int i=0; i<3; i++){
      int N = Integer.valueOf(br.readLine());
      int half = 0;
      coins = new int[N][2];
      for (int j=0; j<N; j++){
        stringTokenizer = new StringTokenizer(br.readLine());
        int price = Integer.valueOf(stringTokenizer.nextToken());
        int count = Integer.valueOf(stringTokenizer.nextToken());
        half+=price*count;
        coins[j][0] = price;
        coins[j][1] = count;
      }
      if (half % 2 != 0) {
        System.out.println(0);
      } else {
        System.out.println(calculate(half/2,N));
      }
    }
  }
  static int calculate(int half, int N){
    int[] dp = new int[half+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i=0; i<N; i++){
      int[] coin = coins[i];
      for (int j=0; j<=half; j++){
        if (dp[j]==Integer.MAX_VALUE)continue;
        if (j+coin[0]<=half&&dp[j]<coin[1]){
          dp[j+coin[0]] = Math.min(dp[j+coin[0]],dp[j]+1);
        }
        dp[j] = 0;
      }
    }
    if (dp[half]!=Integer.MAX_VALUE)return 1;
    else return 0;
  }
}