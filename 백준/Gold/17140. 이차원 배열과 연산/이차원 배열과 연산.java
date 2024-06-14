import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
  static int r;
  static int c;
  static int k;
  static int[][] arr = new int[101][101];
  static int colum = 3;
  static int row = 3;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    r = Integer.valueOf(stringTokenizer.nextToken());
    c = Integer.valueOf(stringTokenizer.nextToken());
    k = Integer.valueOf(stringTokenizer.nextToken());
    int count = 0;

    for (int i=1; i<4; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=1; j<4; j++){
        arr[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    while (count<101){

      if(check()){
        System.out.println(count);
        return;
      }

      if (row>=colum){
        R();
      }
      else {
        C();
      }
      count++;
    }
    System.out.println(-1);
  }

  private static boolean check() {
    if (arr[r][c]==k){
      return true;
    }
    return false;
  }

  private static void C() {
    Map<Integer, Integer> hashMap = new HashMap<>();
    List<Map.Entry<Integer,Integer>> list;

    for (int i=1; i<=colum; i++){
      for (int j=1; j<=row; j++){
        if (arr[j][i]==0)continue;

        if (hashMap.containsKey(arr[j][i])){
          hashMap.put(arr[j][i],hashMap.get(arr[j][i])+1);
        }
        else {
          hashMap.put(arr[j][i],1);
        }
      }

      list = new LinkedList<>(hashMap.entrySet());
      list.sort(new Comparator<Entry<Integer, Integer>>() {
        @Override
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
          if (o1.getValue()==o2.getValue()){
            return o1.getKey()-o2.getKey();
          }
          return o1.getValue()-o2.getValue();
        }});

      int count = 1;
      for (Map.Entry<Integer,Integer> map : list){
        arr[count++][i] = map.getKey();
        arr[count++][i] = map.getValue();
      }
      row = Math.max(count-1,row);
      hashMap.clear();

      while (count <= 99) {
        arr[count++][i] = 0;
        arr[count++][i] = 0;
      }
    }
  }

  private static void R() {
    Map<Integer, Integer> hashMap = new HashMap<>();
    List<Map.Entry<Integer,Integer>> list;

    for (int i=1; i<=row; i++){
      for (int j=1; j<=colum; j++){
        if (arr[i][j]==0){
          continue;
        }
       if (hashMap.containsKey(arr[i][j])){
         hashMap.put(arr[i][j],hashMap.get(arr[i][j])+1);
       }
       else {
         hashMap.put(arr[i][j],1);
       }
      }

      list = new LinkedList<>(hashMap.entrySet());
      list.sort(new Comparator<Entry<Integer, Integer>>() {
        @Override
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
          if (o1.getValue()==o2.getValue()){
            return o1.getKey()-o2.getKey();
          }
          return o1.getValue()-o2.getValue();
      }});

      int count = 1;
      for (Map.Entry<Integer,Integer> map : list){
        arr[i][count++] = map.getKey();
        arr[i][count++] = map.getValue();
      }
      colum = Math.max(colum,count-1);

      hashMap.clear();

      while (count <= 99) {
        arr[i][count++] = 0;
        arr[i][count++] = 0;
      }
    }
  }
}
