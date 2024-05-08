import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int k = Integer.parseInt(stringTokenizer.nextToken());
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o2[1]==o1[1]){
          return o2[0]-o1[0];
        }
        return o2[1]-o1[1];
      }
    });

    Queue<int[]> queue = new LinkedList<>();

    int[][] city = new int[n][4];

    for (int i=0; i<n; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int walkTime = Integer.valueOf(stringTokenizer.nextToken());
      int walkMoney = Integer.valueOf(stringTokenizer.nextToken());
      int bicycleTime = Integer.valueOf(stringTokenizer.nextToken());
      int bicycleMoney = Integer.valueOf(stringTokenizer.nextToken());

      city[i][0] = walkTime;
      city[i][1] = walkMoney;
      city[i][2] = bicycleTime;
      city[i][3] = bicycleMoney;
    }

    queue.add(new int[]{city[0][0],city[0][1]});
    queue.add(new int[]{city[0][2],city[0][3]});

    for (int i=1; i<n; i++){
      while (!queue.isEmpty()){
        priorityQueue.add(queue.poll());
      }
      while (!priorityQueue.isEmpty()){
        int[] tmp = priorityQueue.poll();
        if (tmp[0]+city[i][0]<=k){
          queue.add(new int[]{tmp[0]+city[i][0],tmp[1]+city[i][1]});
        }
        if (tmp[0]+city[i][2]<=k){
          queue.add(new int[]{tmp[0]+city[i][2],tmp[1]+city[i][3]});
        }
      }
    }
    int max = Integer.MIN_VALUE;
    while (queue.size()!=0){
      max = Math.max(max, queue.poll()[1]);
    }
    System.out.println(max);
  }
}