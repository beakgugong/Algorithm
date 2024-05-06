import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int k = Integer.parseInt(stringTokenizer.nextToken());

    int[][] dp = new int[100001][2];
    int num = 0;
    for (int i=n; i>=0; i--){
      dp[i][0] = num;
      dp[i][1] = 2;
      num++;
      if (i==k){
        System.out.println(num-1);
        for(int j=n; j>=k; j--){
          System.out.print(j+" ");
        }
        return;
      }

    }

    for (int i=n+1; i<100001; i++)
    {
      if (i%2==0) {
        if (dp[i/2][0]+1<dp[i-1][0]+1){
          dp[i][0] = dp[i/2][0]+1;
          dp[i][1] = 1;
        }
        else {
          dp[i][0] = dp[i-1][0]+1;
          dp[i][1] = 0;
        }
      }
      else {
        if (dp[(i+1)/2][0]+2 < dp[i-1][0]+1){
          dp[i][0] = dp[(i+1)/2][0]+2;
          dp[i][1] = 2;
        }
        else {
          dp[i][0] = dp[i-1][0]+1;
          dp[i][1] = 0;
        }
      }
    }

    System.out.println(dp[k][0]);
    ArrayList<Integer> arrayList = new ArrayList<>();
    StringBuffer stringBuffer = new StringBuffer();
    arrayList.add(k);

    while (k!=n){
      if (dp[k][1]==0){
        k-=1;
      }
      else if (dp[k][1]==1){
        k/=2;
      }
      else {
        k+=1;
      }
      arrayList.add(k);
    }
    for (int i=arrayList.size()-1; i>-1; i--){
      stringBuffer.append(arrayList.get(i)+" ");
    }
    System.out.println(stringBuffer);
  }
}