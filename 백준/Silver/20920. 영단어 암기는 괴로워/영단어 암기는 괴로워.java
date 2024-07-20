import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    Map<String, Integer> map = new HashMap<>();
    ArrayList<String> arrayList = new ArrayList<>();
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      if (map.containsKey(tmp)) {
        map.put(tmp, map.get(tmp)+1);
      }
      else map.put(tmp,1);
    }

    List<String> list = new ArrayList<>(map.keySet());

    list.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (map.get(o2)==map.get(o1)){
          if (o2.length()==o1.length()){
            for (int i=0; i<o1.length(); i++) {
              if (o1.charAt(i)==o2.charAt(i)){
                continue;
              }
              return o1.charAt(i)-o2.charAt(i);
            }
          }
          return o2.length()-o1.length();
        }
        return map.get(o2)-map.get(o1);
      }
    });

    for (String key : list){
      if (key.length()<M){
        continue;
      }
      arrayList.add(key);
    }

    for (int i=0; i<arrayList.size(); i++){
      stringBuffer.append(arrayList.get(i)+"\n");
    }
    System.out.println(stringBuffer);
  }
}