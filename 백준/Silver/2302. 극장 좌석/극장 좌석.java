import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[41];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i=3; i<41; i++){
      dp[i] = dp[i-1]+dp[i-2];
    }

    int vipCount = Integer.valueOf(br.readLine());
    if (vipCount==0){
      System.out.println(dp[N]);
      return;
    }
    int[] division = new int[vipCount+1];
    int first = Integer.valueOf(br.readLine());
    division[0] = first-1;


    int tail = first;
    int head;

    for (int i=1; i<vipCount; i++){
      head = Integer.valueOf(br.readLine());
      division[i] = head-tail-1;
      tail = head;
    }
    division[vipCount] = N-tail;

    int sum = 1;
    for (int i=0; i<division.length; i++){
      sum*=dp[division[i]];
    }
    System.out.println(sum);
  }
}