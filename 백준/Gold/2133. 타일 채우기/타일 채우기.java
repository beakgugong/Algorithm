import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[N+1];
    dp[0] = 1;
    if (N==0||N==1){
      System.out.println(dp[N]);
      return;
    }
    dp[2] = 3;

    for (int i=4; i<N+1; i+=2){
      dp[i] = dp[i-2]*4-dp[i-4];
    }
    System.out.println(dp[N]);
  }
}