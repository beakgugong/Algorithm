import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[][] dp = new long[31][31];

    for (int i=0; i<31; i++){
      dp[i][0] = 1;
    }
    for (int i=1; i<31; i++){
      for (int j=1; j<=i; j++){
        dp[i][j] = dp[i-1][j]+dp[i][j-1];
      }
    }

    while (br.ready()){
      int N = Integer.valueOf(br.readLine());

      if (N==0){
        break;
      }
      else {
        System.out.println(dp[N][N]);
      }
    }

  }
}