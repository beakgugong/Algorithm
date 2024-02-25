import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  static HashMap<String, Integer> map = new HashMap<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.valueOf(br.readLine());

    for(int i=0; i<test; i++){
      int n = Integer.valueOf(br.readLine());
      for (int j=0; j<n; j++){
        String tmp = br.readLine();
        int space = tmp.indexOf(" ");
        tmp = tmp.substring(space+1);

        if(!map.containsKey(tmp)){
          map.put(tmp,1);
        }
        else {
          map.put(tmp, map.get(tmp)+1);
        }
      }
      if (map.size()==1){
        System.out.println(n);
      }
      else {
        int answer = 1;
        for(String key : map.keySet()){
          answer*=map.get(key)+1;
        }
        System.out.println(answer-1);
      }
      map.clear();
    }
  }
}