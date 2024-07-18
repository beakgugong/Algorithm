import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());

    for (int i=0; i<T; i++){
      int N = Integer.valueOf(br.readLine());
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      Map<Integer,Integer> map = new ConcurrentHashMap<>();
      Map<Integer,Integer> countMap = new HashMap<>();
      int[] sequence = new int[N];

      for (int j=0; j<N; j++){
        int teamNum = Integer.valueOf(stringTokenizer.nextToken());
        if (map.containsKey(teamNum)){
          map.put(teamNum,map.get(teamNum)+1);
        }
        else map.put(teamNum,1);
        sequence[j] = teamNum;
      }

      for (Integer j : map.keySet()){
        if (map.get(j)<6){
          map.remove(j);
          continue;
        }
        else map.put(j,0);
        countMap.put(j,0);
      }
      
      int score = 1;
      ArrayList<Integer> fifthList = new ArrayList<>();

      for (int j : sequence){
        if (!map.containsKey(j)){
          continue;
        }
        if (countMap.get(j)==4){
          fifthList.add(j);
        }
        if (countMap.get(j)<4){
          map.put(j,map.get(j)+score);
          countMap.put(j,countMap.get(j)+1);
        }
        score++;
      }

      int answer = 0;
      int min = Integer.MAX_VALUE;

      for (int j : map.keySet()){
        if (map.get(j)<min){
          min = map.get(j);
          answer = j;
        } else if (map.get(j)==min) {
          answer = fifthList.indexOf(j)<fifthList.indexOf(answer)?j:answer;
        }
      }
      System.out.println(answer);
    }
  }
}