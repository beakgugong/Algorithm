import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Integer[] arr= new Integer[N];
    int sum = 0;
    int min = Integer.MAX_VALUE;
    int low = 0;
    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(st.nextToken());
      sum += arr[i];
      if (low<arr[i]){
        low = arr[i];
      }
    }

    
    while (low<=sum){
      int mid = (sum+low)/2;

      int minute = 0;
      int count = 0;
      for (int i=0; i<N; i++){
        minute += arr[i];
        if (minute>mid){
          count++;
          minute = arr[i];
        }
      }
      count++;
      if (count>M){
        low=mid+1;
      }
      else{
        sum=mid-1;
        min = Math.min(min,mid);
      }
    }
    System.out.println(min);
  }
}
