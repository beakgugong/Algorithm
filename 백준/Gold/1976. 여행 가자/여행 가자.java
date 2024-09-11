import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static boolean[][] cityInfo;
    static int N;
    static int M;
    static boolean[] visit;
    static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    M = Integer.valueOf(br.readLine());
    cityInfo = new boolean[N][N];
    visit = new boolean[N];
    StringTokenizer stringTokenizer;


    for (int i=0; i<N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        int tmp = Integer.valueOf(stringTokenizer.nextToken());
        cityInfo[i][j] = tmp==0?false:true;
      }
    }

    stringTokenizer = new StringTokenizer(br.readLine());
    int start = 0;

    for (int i=0; i<M; i++){
      start = Integer.valueOf(stringTokenizer.nextToken())-1;
      set.add(start);
    }

    dfs(start);
    if (set.isEmpty()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
  static void dfs(int num){
    if (set.contains(num)){
      set.remove(num);
    }
    for (int i=0; i<N; i++){
      if (cityInfo[num][i]==false||visit[i]){
        continue;
      }
      visit[i] = true;
      dfs(i);
    }
    return;
  }
}