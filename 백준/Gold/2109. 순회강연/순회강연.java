import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    StringTokenizer stringTokenizer;

    if(N==0){
      System.out.println(0);
      return;
    }
    
    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int money = Integer.valueOf(stringTokenizer.nextToken());
      int day = Integer.valueOf(stringTokenizer.nextToken());
      if (map.containsKey(day)) {
        map.get(day).add(money);
      } else {
        map.put(day, new ArrayList<>());
        map.get(day).add(money);
        arrayList.add(day);
      }
    }
    Collections.sort(arrayList, Collections.reverseOrder());

    int day = arrayList.get(0);

  while (day>0) {
    if (map.containsKey(day)) {
      for (int j = 0; j <map.get(day).size(); j++) {
        priorityQueue.add(map.get(day).get(j));
      }
    }
    if (!priorityQueue.isEmpty()) {
      answer += priorityQueue.poll();
      day--;
    }
    else
      day--;
  }

    System.out.println(answer);
  }
}