import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int C = Integer.valueOf(stringTokenizer.nextToken());
    int[] map = new int[N];

    for (int i=0; i<N; i++){
      map[i] = Integer.valueOf(br.readLine());
    }
    Arrays.sort(map);

    int low = 1;
    int high = map[N-1];

    while (low<=high){
      int mid = (low+high)/2;
      int count = 1;
      int before = map[0];

      for (int i=1; i<N; i++){
        if (before+mid<=map[i]){
          before = map[i];
          count++;
        }
      }
      if (count>=C){
        low = mid+1;
      }
      else {
        high = mid-1;
      }
    }
    System.out.println(high);
  }
}