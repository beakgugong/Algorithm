import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[] binarySearch = new int[N];
    String[] nickname = new String[N];
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      String tmp = stringTokenizer.nextToken();
      Integer max = Integer.valueOf(stringTokenizer.nextToken());
      binarySearch[i] = max;
      nickname[i] = tmp;
    }

    for (int i=0; i<M; i++){
      int tmp = Integer.valueOf(br.readLine());
      int low = 0;
      int high = N-1;

      while (low<=high){
        int mid = (low+high)/2;

        if (tmp<=binarySearch[mid]){
          high = mid-1;
        }
        else {
          low = mid+1;
        }
      }
      stringBuffer.append(nickname[high+1]+"\n");
    }
    System.out.println(stringBuffer);
  }
}