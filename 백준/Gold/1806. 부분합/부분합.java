import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int S = Integer.valueOf(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());
    int[] arr = new int[N];

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
      if (arr[i] == S) {
        System.out.println(1);
        return;
      }
    }

    int answer = Integer.MAX_VALUE;
    int one = 0;
    int two = 1;
    int sum = arr[one]+arr[two];

    while (two<N-1){
      if (sum>=S){
        answer = Math.min(answer,two-one);
        sum -= arr[one++];
      } else {
        sum += arr[++two];
      }
    }

    if (sum>=S) {
      while (sum>=S) {
        sum -= arr[one++];
        answer = Math.min(answer, two-one+1);
      }
    }

    if (answer != Integer.MAX_VALUE) {
      System.out.println(answer+1);
    } else {
      System.out.println(0);
    }
  }
}