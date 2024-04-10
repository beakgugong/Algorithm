import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    long N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());
    ArrayList<Integer> arrayList = new ArrayList<>();

    for (int i=0; i<M; i++){
      int moveTime = Integer.valueOf(stringTokenizer.nextToken());
      arrayList.add(moveTime);
    }
    if (N <= M) {
      System.out.println(N);
      return;
    }

    long low = 1;
    long high = 60000000000L;
    long time = 0;

    while (low<=high){
      long mid = (low+high)/2;
      long count = M;

      for (int i=0; i<M; i++){
        long tmp = mid/arrayList.get(i);
        count+=tmp;
      }
      if (count<N){
        low = mid+1;
      }
      else if (count==N){
        time = mid;
        break;
      }
      else {
        time = mid;
        high = mid-1;
      }
    }

    long answer = M;
    int tmp = 0;
    for (int i=0; i<M; i++){
      if (((time-1)/arrayList.get(i)>1)){
        tmp = i;
      }
      answer += ((time-1)/arrayList.get(i));
    }
    if (answer==N){
      System.out.println(tmp+1);
      return;
    }

    for (int i=0; i<M; i++){
      if (time%arrayList.get(i) == 0){
        answer++;
      }
      if (answer==N){
        System.out.println(i+1);
        return;
      }
    }
  }
}
