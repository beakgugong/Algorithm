import java.awt.image.AffineTransformOp;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    String[] dp = new String[1001];

    for (int i=1; i< dp.length; i++){
      if (i%2==0) {
        dp[i] = "CY";
      }
      else dp[i] = "SK";
    }
    System.out.println(dp[N]);

  }
}