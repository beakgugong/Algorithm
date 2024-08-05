import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int D = Integer.valueOf(st.nextToken());
    int[][] arr = new int[N][3];
    int dp[] = new int[10001];

    for (int i=0; i<dp.length; i++){
      dp[i] = i;
    }

    for (int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.valueOf(st.nextToken());
      int end = Integer.valueOf(st.nextToken());
      int distance = Integer.valueOf(st.nextToken());

      arr[i][0] = start;
      arr[i][1] = end;
      arr[i][2] = distance;
    }

    for (int i=1; i<D+1; i++){
      dp[i] = Math.min(dp[i],dp[i-1]+1);
      for (int j=0; j<N; j++){
        if (arr[j][1]==i){
          dp[i] = Math.min(dp[arr[j][0]]+arr[j][2], dp[i]);
        }
      }
    }
    System.out.println(dp[D]);
  }
}