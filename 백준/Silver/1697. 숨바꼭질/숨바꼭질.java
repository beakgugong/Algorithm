import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    int[] dp = new int[100001];
    Arrays.fill(dp,Integer.MAX_VALUE);
    dp[N] = 0;

    Queue<Integer> queue = new LinkedList();
    queue.add(N);

    while (!queue.isEmpty()){
      int n = queue.poll();
      int plus = n+1;
      int minus = n-1;
      int multiple = n*2;

      if (multiple<100001&&dp[multiple]==Integer.MAX_VALUE){
        dp[multiple] = dp[n]+1;
        queue.add(multiple);
      }
      if (plus<100001&&dp[plus]==Integer.MAX_VALUE){
        dp[plus] = dp[n]+1;
        queue.add(plus);
      }
      if (minus>=0&&dp[minus]==Integer.MAX_VALUE){
        dp[minus] = dp[n]+1;
        queue.add(minus);
      }

      if (dp[K]!=Integer.MAX_VALUE){
        System.out.println(dp[K]);
        return;
      }
    }

  }
}