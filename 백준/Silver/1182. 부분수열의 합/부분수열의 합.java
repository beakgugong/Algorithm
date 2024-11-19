import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N,S,answer;
  static int[] num;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(stringTokenizer.nextToken());
    S = Integer.parseInt(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());
    num = new int[N];
    visited = new boolean[N];
    answer = 0;

    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    
    dfs(0, 0);
    if (S == 0) {
      answer--;
    }
    System.out.println(answer);
  }

  static void dfs(long sum, int index){
    if(index==N){
      if (sum==S){
        answer++;
      }
      return;
    }
    dfs(sum, index+1);
    dfs(sum+num[index], index+1);
  }
}