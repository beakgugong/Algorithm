import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());

    if (N==0){
      System.out.println(0);
      System.out.println(0);
      return;
    }
    else {
      int tmp = 0;
      if (N>0){
        tmp = plusFib(N);
      }
      else {
        if (N==-1){
          System.out.println(1);
          System.out.println(1);
          return;
        }
        else {
          tmp = minusFib(N);
        }
      }
      if (tmp>0){
        System.out.println(1);
        System.out.println(tmp);
      }
      else{
        System.out.println(-1);
        System.out.println(Math.abs(tmp));
      }
    }

  }
  static int plusFib(int N){
    int[] dp = new int[N+1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i=2; i<N+1; i++){
      dp[i] = (dp[i-1]+dp[i-2])%1000000000;
    }
    return dp[N];
  }
  static int minusFib(int m){
    int N = Math.abs(m);
    int[] dp = new int[N+1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = -1;
    for (int i=3; i<N+1; i++){
      dp[i] = (dp[i-2]-dp[i-1])%1000000000;

    }
    return dp[N];
  }
}