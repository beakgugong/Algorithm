import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
  static int N;
  static ArrayList<Integer> arrayList;
  static boolean[] visit;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    arrayList = new ArrayList<>();
    visit = new boolean[N+1];
    arr = new int[N+1];

    for (int i=0; i<N; i++){
      arr[i+1] = Integer.valueOf(br.readLine());
    }

    for (int i=1; i<=N; i++){
      visit[i] = true;
      dfs(i, i);
      visit[i] = false;
    }
    System.out.println(arrayList.size());
    for (int i : arrayList){
      System.out.println(i);
    }
  }

  private static void dfs(int up, int down) {
    if (!visit[arr[up]]){
      visit[arr[up]] = true;
      dfs(arr[up], down);
      visit[arr[up]] = false;
    }
    if (arr[up]==down){
      arrayList.add(down);
    }
  }
}