import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int d = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());
    int c = Integer.valueOf(st.nextToken());
    int max = Integer.MIN_VALUE;
    List<Integer> list = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();

    for (int i=0; i<n; i++){
      list.add(Integer.valueOf(br.readLine()));
    }

    for (int i=0; i<k; i++){
      if (map.containsKey(list.get(i))) {
        map.put(list.get(i), map.get(list.get(i)) + 1);
      }
      else map.put(list.get(i),1);
    }
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
    }
    else map.put(c,1);

    int tmp = 0;
    for (int i=0; i<n; i++){
      max = Math.max(max, map.size());
      tmp = list.get(i);
      map.put(tmp,map.get(tmp)-1);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      }
      else map.put(c,1);
      if (map.get(tmp)==0){
        map.remove(tmp);
      }
      if (map.containsKey(list.get((i+k)%n))) {
        map.put(list.get((i + k) % n), map.get(list.get((i + k) % n)) + 1);
      }
      else map.put(list.get((i + k) % n),1);
    }

    System.out.println(max);
  }
}