import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(bufferedReader.readLine());

    for (int i=0; i<T; i++){
      int N = Integer.valueOf(bufferedReader.readLine());
      int[] prices = new int[N];
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int max = Integer.MIN_VALUE;
      long sum = 0;

      for (int j=0; j<N; j++){
        prices[j] = Integer.valueOf(stringTokenizer.nextToken());
      }

      max = prices[N-1];

      for (int j=N-2; j>-1; j--){
        if (max<prices[j]){
          max = prices[j];
        }
        else {
          sum+= max-prices[j];
        }
      }
      System.out.println(sum);
    }
  }
}