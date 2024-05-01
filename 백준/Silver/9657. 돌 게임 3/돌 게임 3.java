import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    String[] dp = new String[1001];
    Arrays.fill(dp, "SK");
    for (int i=2; i<1001; i++){
       if (i%7==0||i%7==2){
         dp[i] = "CY";
       }
    }
    System.out.println(dp[N]);
  }
}