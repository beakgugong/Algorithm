import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] km = new int[N-1];
    long[] price = new long[N];
    long min;
    long prefixSum = 0;

    for (int i=0; i<N-1; i++){
      km[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++){
      price[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    min = price[0];
    prefixSum = min*km[0];

    for (int i=1; i<N-1; i++){
      min = Math.min(min,price[i]);

      prefixSum+=min*km[i];
    }

    System.out.println(prefixSum);

 }
}