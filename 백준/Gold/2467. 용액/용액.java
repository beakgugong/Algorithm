import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    int[] answer = {1000000000, 1000000000};
    int[] tmp = {1000000000, 1000000000};

    for (int i = 0; i < arr.length; i++) {
      int candy = arr[i];
      int low = i+1;
      int high = arr.length-1;

      while (low <= high) {
        int mid = (low + high) / 2;

        if (candy+arr[mid]>0) {
          if (Math.abs(candy + arr[mid]) < Math.abs(tmp[0]+tmp[1])) {
            high = mid - 1;
            tmp[0] = candy;
            tmp[1] = arr[mid];
          }
          else high = mid-1;
        } else if (candy+arr[mid]<=0){
          if (Math.abs(candy + arr[mid]) < Math.abs(tmp[0]+tmp[1])) {
            low = mid + 1;
            tmp[0] = candy;
            tmp[1] = arr[mid];
          }
          else low = mid+1;
        }
      }

      if (Math.abs(answer[0] + answer[1]) > Math.abs(tmp[0] + tmp[1])) {
        answer[0] = tmp[0];
        answer[1] = tmp[1];
      }
      tmp[0] = 1000000000;
      tmp[1] = 1000000000;
    }
    Arrays.sort(answer);
    System.out.println(answer[0]+" "+answer[1]);
  }

}
