import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] arr = new int[N];
    int[] count = new int[N];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++){
      count[i] = i;
    }

    for (int i=0; i<N; i++){
      int tmp = Integer.valueOf(stringTokenizer.nextToken());
      int copy = tmp;

      while (true){
        if (arr[tmp]==0 && count[tmp]>copy-1){
          arr[tmp] = i+1;
          for (int j=tmp+1; j<N; j++){
            count[j] -= 1;
          }
          break;
        }
        else {
          tmp++;
        }
      }
    }
    for (int i : arr){
      System.out.print(i + " ");
    }
  }
}