import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  static int N;
  static int C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    C = Integer.valueOf(stringTokenizer.nextToken());
    int[] house = new int[N];

    for (int i=0; i<N; i++){
      house[i] = Integer.valueOf(br.readLine());
    }
    Arrays.sort(house);

    int low = 0;
    int high = house[N-1];

    while (low<=high){
      int mid = (low+high)/2;
      int count = 1;
      int start = house[0];

      for (int i=1; i<N; i++){
        if (house[i]>=start+mid){
          start = house[i];
          count++;
        }
      }

      if (count>=C){
        low = mid+1;
      }else if (count<C){
        high = mid-1;
      }
    }
    System.out.println(high);
  }
}