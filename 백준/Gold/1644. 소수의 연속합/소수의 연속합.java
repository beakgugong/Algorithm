import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int tmp = 0;
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int i=2; i<=N; i++){
      if(primeNumber(i)){
        tmp+=i;
        queue.add(i);
      }
      else continue;
      if (tmp==N){
        answer++;
      }
      else if (tmp>N){
        while (tmp>=N) {
          tmp -= queue.poll();
          if (tmp==N){
            answer++;
          }
        }
      }
    }
    System.out.println(answer);
  }
  static boolean primeNumber(int j){
    if (j==2){
      return true;
    }
    for (int i=2; i<=Math.sqrt(j); i++){
      if (j%i==0){
        return false;
      }
    }
    return true;
  }
}