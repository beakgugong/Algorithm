import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    int answer = 0;

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    Arrays.sort(arr);

    for (int i=0; i<N; i++){
      int num = arr[i];
      for (int j=0; j<N; j++){
        if (i==j){
          continue;
        }
        int tmp = arr[j];
        int low = 0;
        int high = N-1;
        boolean flag = false;

        while (low<=high){
          int mid = (low+high)/2;
          if (mid==j||mid==i){
            high-=1;
            continue;
          }

          if (tmp+arr[mid]>num){
            high = mid-1;
          }
          else if (tmp+arr[mid]<num){
            low = mid+1;
          }
          else {
            flag = true;
            break;
          }
        }
        if (flag){
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);

  }
}