import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int S = Integer.valueOf(stringTokenizer.nextToken());
    int C = Integer.valueOf(stringTokenizer.nextToken());
    ArrayList<Integer> pa = new ArrayList<>();
    int high = 1000000000;
    int low = 1;
    long sum = 0;
    int answer = Integer.MIN_VALUE;

    for (int i=0; i<S; i++){
      pa.add(Integer.valueOf(br.readLine()));
      //high = Math.min(high,pa.get(i));
      sum+=pa.get(i);
    }

    while (low<=high){
      int mid = (low+high)/2;
      int count = 0;
      if (mid==0){
      answer=0;
      break;
      }
      for (int i=0; i<S; i++){
        int leng = pa.get(i);

        count+=(leng/mid);
      }
      if (count<C){
        high = mid-1;
      }
      else {
        low = mid+1;
        answer = Math.max(mid,answer);
      }
    }

    System.out.println(sum-(long) C*answer);
  }

}
