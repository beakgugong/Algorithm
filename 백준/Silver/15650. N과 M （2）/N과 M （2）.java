import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static boolean[] visit;
  static ArrayList<Integer> arrayList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    visit = new boolean[N+1];

    dfs(0,1);
  }
  static void dfs(int count, int idx){
    if (count==M){
      for (int i :arrayList){
        System.out.print(i+" ");
      }
      System.out.println();
      return;
    }

    for (int i= idx; i<=N; i++){
      arrayList.add(i);
      dfs(count+1,i+1);
      arrayList.remove(arrayList.size()-1);
    }
  }
}