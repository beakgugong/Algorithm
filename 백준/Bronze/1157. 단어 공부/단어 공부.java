import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    str = str.toUpperCase();
    char answer = 'c';
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i=0; i<str.length(); i++){
      if (map.containsKey(str.charAt(i))){
        map.put(str.charAt(i),map.get(str.charAt(i))+1);
      }
      else {
        map.put(str.charAt(i),1);
      }
    }

    for (Character character :map.keySet()){
      if (max<map.get(character)){
        max = map.get(character);
        answer = character;
      } else if (max==map.get(character)) {
        answer = '?';
      }
    }
    System.out.println(answer);
  }
}