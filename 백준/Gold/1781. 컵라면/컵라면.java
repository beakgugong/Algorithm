import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    StringTokenizer stringTokenizer;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    int answer = 0;


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int deadline = Integer.valueOf(stringTokenizer.nextToken());
      int ramen = Integer.valueOf(stringTokenizer.nextToken());

      if (map.containsKey(deadline)){
        map.get(deadline).add(ramen);
      }
      else {
        map.put(deadline,new ArrayList<>());
        map.get(deadline).add(ramen);
        arrayList.add(deadline);
      }
    }

    Collections.sort(arrayList,Collections.reverseOrder());
    int day = arrayList.get(0);

    while (day>0){
      if (map.containsKey(day)) {
        for (int i = 0; i < map.get(day).size(); i++) {
          priorityQueue.add(map.get(day).get(i));
        }
        answer+=priorityQueue.poll();
      }
      else {
        if (!priorityQueue.isEmpty()){
          answer+= priorityQueue.poll();
        }
      }
      day--;
    }
    System.out.println(answer);
  }
}