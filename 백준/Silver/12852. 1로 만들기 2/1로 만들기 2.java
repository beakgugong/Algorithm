import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] dp = new int[N+1];
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(0);
    arrayList.add(1);
    dp[0] = 0;
    dp[1] = 0;

    for(int i=2; i<N+1; i++){
      int tmp;
      if (i==2||i==3){
        dp[i] = 1;
        tmp = i;
        arrayList.add(1);
        continue;
      }
      dp[i] = dp[i-1]+1;
      tmp = i-1;
      if (i%2==0){
        if (dp[i]>dp[i/2]+1){
          dp[i] = dp[i/2]+1;
          tmp = i/2;
        }
      }
      if (i%3==0){
        if (dp[i]>dp[i/3]+1){
          dp[i] = dp[i/3]+1;
          tmp = i/3;
        }
      }
      arrayList.add(tmp);
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(N+" ");
    int tmp = N;

    while (tmp!=1){
      tmp = arrayList.get(tmp);
      stringBuilder.append(tmp+" ");
    }

    System.out.println(dp[N]);
    System.out.println(stringBuilder);
  }
}