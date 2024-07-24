import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    String str = br.readLine();
    boolean[] visit = new boolean[N];
    int answer = 0;


    for (int i=0; i<N; i++){
      boolean flag = false;
      if (str.charAt(i)=='H'){
        continue;
      }
      for (int j=K; j>0; j--) {
        if (i - j < 0) {
          continue;
        }
        if (str.charAt(i-j)=='H'&&!visit[i-j]){
          answer++;
          visit[i-j] =true;
          flag = true;
          break;
        }
      }
      if(flag){
        continue;
      }
      for (int j=1; j<K+1; j++) {
        if (i + j > N-1) {
          continue;
        }
        if (str.charAt(i+j)=='H'&&!visit[i+j]){
          answer++;
          visit[i+j] =true;
          break;
        }
      }
    }
    System.out.println(answer);
  }
}