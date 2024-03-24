import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] number = new int[N+1];
    int[] cnt = new int[100001];
    long answer = 1;

    for (int i=1; i<N+1; i++){
      number[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    int one = 1;
    int two = 0;
    while (one<N){
      while (two+1<=N && cnt[number[two+1]]==0){
        two++;
        cnt[number[two]]++;
      }
      answer += two-one+1;
      cnt[number[one++]]--;
    }
    System.out.println(answer);
  }
}