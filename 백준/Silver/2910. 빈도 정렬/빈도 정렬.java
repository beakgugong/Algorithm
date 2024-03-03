import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int C = Integer.valueOf(stringTokenizer.nextToken());
    String[] arr = br.readLine().split(" ");
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> sequence = new ArrayList<>();

    for(int i=0; i<arr.length; i++){
      int num = Integer.valueOf(arr[i]);
      if(map.containsKey(num)){
         map.put(num, map.get(num)+1);
      }
      else {
        sequence.add(Integer.valueOf(arr[i]));
        map.put(num, 1);
      }
    }

    List<Integer> keySet = new ArrayList<>(map.keySet());
    keySet.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if(map.get(o1) - map.get(o2) == 0){

          return sequence.indexOf(o1) - sequence.indexOf(o2);

        }
        return map.get(o2).compareTo(map.get(o1));
      }
    });

    for (Integer key : keySet) {
      for (int i=0; i<map.get(key); i++){
        System.out.print(key+" ");
      }
    }

  }
}
