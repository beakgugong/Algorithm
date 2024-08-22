import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    int[] count = new int[26];

    for (int i=0; i<T; i++){
      String str = br.readLine();
      int K = Integer.valueOf(br.readLine());
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      Map<Character, Integer> map = new HashMap<>();
      StringBuffer tmp = new StringBuffer(str);
      int[] fromIndex = new int[26];

      for (int j=0; j<str.length(); j++){
        if(map.containsKey(str.charAt(j))) {
          map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
        }
        else map.put(str.charAt(j), 1);

        if (map.get(str.charAt(j))==K){
          int k = str.charAt(j)-'a';
          int compare = str.indexOf(str.charAt(j),fromIndex[k]);
          min = Math.min(min,j-compare+1);
          max = Math.max(max,j-compare+1);
          map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
          fromIndex[k] = compare+1;
        }
      }

      if (min==Integer.MAX_VALUE){
        System.out.println(-1);
      }
      else {
        System.out.println(min + " " + max);
      }
    }
  }
}