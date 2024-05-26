import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    Integer[] arr = new Integer[N+1];
    Integer[] answer = new Integer[N+1];
    answer[0] = 0;
    for (int i=1; i<N+1; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
      answer[i]=0;
    }

    for (int i=1; i<N; i++){
      answer[i]++;
      answer[i+1]++;
      double before = arr[i+1]-arr[i];
      for (int j=i+2; j<N+1; j++){
        double current = (double) (arr[j]-arr[i])/(j-i);
        if (before<current){
          answer[i]++;
          answer[j]++;
          before = current;
        }
      }
    }

    Arrays.sort(answer,Collections.reverseOrder());
    System.out.println(answer[0]);
  }
}