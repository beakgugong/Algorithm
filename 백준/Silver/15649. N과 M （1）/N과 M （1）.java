import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      visited = new boolean[N + 1];

      dfs(0,1);



  }
  static void dfs(int count, int num){

      if (count == M){
          System.out.println(list.toString().replace("[", "").replace("]", "").replace(",",""));
          return;
    }

      for (int i = 1; i < N+1; i++){
          if (!visited[i]){
              visited[i] = true;
              list.add(i);
              dfs(count+1, i);
              list.remove(list.indexOf(i));
              visited[i] = false;
          }else continue;
      }
  }
}