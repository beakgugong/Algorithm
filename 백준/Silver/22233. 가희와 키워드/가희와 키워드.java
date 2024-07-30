import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    HashMap<String, Integer> hashMap = new HashMap<>();

    for (int i=0; i<N; i++){
      hashMap.put(br.readLine(), 1);
    }

    for (int i=0; i<M; i++){
      String[] strings = br.readLine().split(",");

      for (int j=0; j<strings.length; j++){
        if (hashMap.containsKey(strings[j]));
        hashMap.remove(strings[j]);
      }
      System.out.println(hashMap.size());
    }
  }
}