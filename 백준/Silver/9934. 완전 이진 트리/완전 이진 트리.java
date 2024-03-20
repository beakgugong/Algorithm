import java.io.*;
import java.util.*;

public class Main {

  static int K;
  static ArrayList<ArrayList<Integer>> arrayList;
  static String[] num;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.valueOf(br.readLine());
    num = br.readLine().split(" ");
    arrayList = new ArrayList<>();

    for (int i=0; i<K; i++){
      arrayList.add(new ArrayList<>());
    }

    dfs(0,num.length-1,0);
    for (int i=0; i< arrayList.size(); i++){
      for (int j=0; j<arrayList.get(i).size(); j++)
      {
        System.out.print(arrayList.get(i).get(j)+" ");
      }
      System.out.println();
    }
  }
  static void dfs(int start, int end, int depth){
    if (depth==K)return;

    int mid = (start+end)/2;
    arrayList.get(depth).add(Integer.valueOf(num[mid]));

    dfs(start,mid-1,depth+1);
    dfs(mid+1, end,depth+1);
  }
}