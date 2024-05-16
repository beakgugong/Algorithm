import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] arr;
  static boolean[] visit;
  static ArrayList<Integer> arrayList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    arr = new int[N+1];
    visit = new boolean[N+1];
    arrayList = new ArrayList<>();

    for (int i=1; i<N+1; i++){
      arr[i] = Integer.valueOf(br.readLine());
    }
    for (int i=1; i<N+1; i++){
      visit[i] = true;
      dfs(i, i);
      visit[i] = false;
    }

    Collections.sort(arrayList);
    System.out.println(arrayList.size());
    for (int i=0; i<arrayList.size(); i++){
      System.out.println(arrayList.get(i));
    }

  }
  static void dfs(int first, int second){
    if (!visit[arr[first]]){
      visit[arr[first]] = true;
      dfs(arr[first],second);
      visit[arr[first]] = false;
    }
    if (arr[first]==second){
      arrayList.add(second);
    }
  }
}
