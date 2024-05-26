import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int M;
  static int N;
  static boolean[] visit;
  static Map<Integer,Integer> hashMap;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    N = Integer.valueOf(br.readLine());
    M = Integer.valueOf(br.readLine());
    map = new int[N+1][N+1];
    visit = new boolean[N+1];
    hashMap = new HashMap<>();


    for (int i=1; i<N+1; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=1; j<N+1; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    stringTokenizer = new StringTokenizer(br.readLine());
    int start = 0;
    for (int i=0; i<M; i++) {
      start =Integer.valueOf(stringTokenizer.nextToken());
      hashMap.put(start ,1);
    }

    dfs(start);
//    for (Integer i : hashMap.keySet()){
//      System.out.println(i);
//    }
    if (hashMap.size()==0){
      System.out.println("YES");
    }
    else {
      System.out.println("NO");
    }

  }
  static void dfs(int i){
    if (hashMap.containsKey(i)){
      hashMap.remove(i);
    }
    for (int k=1; k<N+1; k++){
      if (map[i][k]==0||visit[k]||i==k){
        continue;
      }
      visit[i] = true;
      dfs(k);
    }
    return;
  }
}