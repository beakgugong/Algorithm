import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int S = Integer.valueOf(stringTokenizer.nextToken());
    int[] arr = new int[N];
    Queue<Integer> queue = new LinkedList<>();
    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    int sum = 0;
    int answer = Integer.MAX_VALUE;
    for (int i=0; i<N; i++){
      queue.add(arr[i]);
      sum += arr[i];

      if (sum>=S){
        while (sum>=S) {
          answer = Math.min(answer,queue.size());
          sum -= queue.poll();
        }
      }
    }

    if (answer==Integer.MAX_VALUE){
      System.out.println(0);
      return;
    }
    System.out.println(answer);
  }
}