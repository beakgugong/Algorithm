import com.sun.jdi.IntegerValue;
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();

    for (int i=0; i<N; i++){
      list.add(Integer.valueOf(stringTokenizer.nextToken()));
    }

    List<Integer> answer = new ArrayList<>();
    answer.add(0);

    for (int i=0; i<N; i++){
      int tmp = list.get(i);
      if (answer.get(answer.size()-1)<tmp){
        answer.add(tmp);
      }
      else{
        int low = 0;
        int high = answer.size()-1;

        while (low<high){
          int mid = (low+high)/2;

          if (answer.get(mid)<tmp){
            low = mid+1;
          }
          else {
            high = mid;
          }
        }
        answer.set(high,tmp);
      }
    }
    System.out.println(answer.size()-1);
  }
}
