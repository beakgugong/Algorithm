import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());
    int[] jewel = new int[M];
    int min = Integer.MAX_VALUE;
    int max = 0;

    for (int i=0; i<M; i++) {
      jewel[i] = Integer.valueOf(br.readLine());
      max = Math.max(max,jewel[i]);
    }

    int low = 1;
    while (low<=max){
      int mid = (max+low)/2;
      int num = 0;

      for (int i=0; i<M; i++){
        num += jewel[i]/mid;

        if (jewel[i]%mid>0)num++;
      }
      if (num>N){
        low = mid+1;
      } else if (num<=N) {
       max = mid-1;
       min = Math.min(min,mid);
      }
    }

    System.out.println(min);
  }
}