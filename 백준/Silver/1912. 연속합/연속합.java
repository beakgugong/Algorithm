import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    Integer[] arr = new Integer[N];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int answer = Integer.MIN_VALUE;
    int max = 0;
    int one=0;

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<N; i++){
      max+=arr[i];
      if (max<0){
        max = 0;
        continue;
      }
      if (answer<max){
        answer = max;
      }
    }
    
    Arrays.sort(arr, Collections.reverseOrder());
    if (arr[0]<0){
      System.out.println(arr[0]);
      return;
    }
    System.out.println(answer);
  }
}