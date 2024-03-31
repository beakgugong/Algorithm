import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
  static int N;
  static int L;
  static int[] arr;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;
  static char[] operator = {'+','-','*','/'};
  static Map<Character, Integer> map;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    arr = new int[N];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    map = new HashMap<>();
    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    stringTokenizer = new StringTokenizer(br.readLine());
    for (int i=0; i<4; i++){
      map.put(operator[i],Integer.valueOf(stringTokenizer.nextToken()));
    }

    dfs(1, arr[0]);

    System.out.println(max);
    System.out.println(min);
  }
  static void dfs(int count,int amout){
    if (count-1==N-1){
      if (amout>max) max = amout;
      if (amout<min) min = amout;
      return;
    }

    for (int i=0; i<4; i++){
      int copy = amout;
      if (map.get(operator[i])==0){
        continue;
      }
      else {
        if (i==0){
          amout+=arr[count];
        } else if (i==1) {
          amout-=arr[count];
        }
        else if (i==2){
          amout*=arr[count];
        }
        else {
          amout/=arr[count];
        }
        map.put(operator[i],map.get(operator[i])-1);
        dfs(count+1,amout);

      }
      map.put(operator[i],map.get(operator[i])+1);
      amout = copy;
    }
  }
}