import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int X = Integer.valueOf(br.readLine());
    int answer = 0;
    int[] arr = new int[N];

    for (int i = 0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    Arrays.sort(arr);

    int one = 0;
    int two = N-1;
    while (one<two){
      if (arr[one]+arr[two]==X){
        answer++;
        one++;
        two--;
      }
      else if (arr[one]+arr[two]>X){
        two--;
      }
      else{
        one++;
      }
    }
    System.out.println(answer);
  }
}