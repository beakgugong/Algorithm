import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    String game = stringTokenizer.nextToken();
    Map<String, Integer> map = new HashMap<>();

    for (int i=0; i<N; i++){
      String name = br.readLine();
      if (map.containsKey(name)) {
        map.put(name, map.get(name)+1);
      }
      else {
        map.put(name,1);
      }
    }

    switch (game){
      case "Y":
        System.out.println(map.size());
        break;
      case "F":
        System.out.println(map.size()/2);
        break;
      case "O":
        System.out.println(map.size()/3);
        break;
    }
  }
}