import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int M = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int beforeLamp = 0;
    int first = 0;
    int last = 0;
    int answer = 0;

    for (int i=0; i<M; i++){
      int streetLamp = Integer.valueOf(stringTokenizer.nextToken());
      int candidate = Math.max(answer*2,streetLamp-beforeLamp);
      if (i==0){
        first = streetLamp;
      }
      if (i==M-1) {
        last = streetLamp;
      }
      answer = (candidate%2)==0?(candidate/2):(candidate/2)+1;
      beforeLamp = streetLamp;
    }

    answer = Math.max(answer,first);
    answer = Math.max(answer,N-last);

    System.out.println(answer);
  }
}