import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());
    int[] daySpend = new int[N];
    int sum = 0;
    int low = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      daySpend[i] = Integer.valueOf(st.nextToken());
      sum += daySpend[i];
      low = Math.max(low,daySpend[i]);
    }


    while (low<=sum){
      int mid = (sum+low)/2;
      int tmp = 0;
      int count = 0;
      for (int i=0; i<N; i++){
        tmp+=daySpend[i];
        if (tmp>mid){
          tmp = daySpend[i];
          count++;
        }
      }
      count++;
      if (count>M){
        low= mid+1;
      }
      else {
        sum = mid-1;
        min = Math.min(min, mid);
      }
    }
    System.out.println(min);
  }
}
