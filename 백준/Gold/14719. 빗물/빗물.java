import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,1};
  static int W,H;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    H = Integer.valueOf(stringTokenizer.nextToken());
    W = Integer.valueOf(stringTokenizer.nextToken());
    arr = new int[W+1];
    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=1; i<=W; i++){
        arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    int answer = 0;

    for (int i=2; i<W; i++){
      int left=0;
      int right=0;

      for (int j=1; j<i; j++){
        if (arr[j]>left){
          left = arr[j];
        }
      }
      for (int j=i+1; j<=W; j++){
        if (arr[j]>right){
          right = arr[j];
        }
      }
      int tmp = Math.min(left,right);

      if ((tmp-arr[i])<0){
        continue;
      }
      answer += (tmp-arr[i]);

    }

    System.out.println(answer);
  }
}
