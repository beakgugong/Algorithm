import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    Map<Integer, String> intMap = new HashMap<>();
    Map<String, Integer> strMap = new HashMap<>();

    int pocket = Integer.valueOf(stringTokenizer.nextToken());
    int problem = Integer.valueOf(stringTokenizer.nextToken());

    for(int i=0; i<pocket; i++){
      String tmp =  br.readLine();
      intMap.put(i+1,tmp);
      strMap.put(tmp,i+1);
    }

    for(int i=0; i<problem; i++){
      String tmp = br.readLine();
      try {
        int num = Integer.valueOf(tmp);
        System.out.println(intMap.get(num));
      }
      catch (NumberFormatException e) {
        System.out.println(strMap.get(tmp));
      }
    }
  }
}