import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    List<Gemstone> list = new ArrayList<>();
    List<Integer> bag = new ArrayList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    long answer = 0;


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int weight = Integer.valueOf(stringTokenizer.nextToken());
      int price = Integer.valueOf(stringTokenizer.nextToken());
      list.add(new Gemstone(weight,price));
    }

    for (int i=0; i<K; i++){
      bag.add(Integer.valueOf(br.readLine()));
    }

    Collections.sort(list, new Comparator<Gemstone>() {
      @Override
      public int compare(Gemstone o1, Gemstone o2) {
        return o1.weight-o2.weight;
      }
    });
    Collections.sort(bag);

    int j = 0;
    for (int i=0; i<K; i++){
      while (j<N && list.get(j).weight<=bag.get(i)){
        priorityQueue.add(list.get(j).price);
        j++;
      }
      if (!priorityQueue.isEmpty()){
        answer+= priorityQueue.poll();
      }
    }
    System.out.println(answer);
  }
  static class Gemstone{
    int weight;
    int price;

    public Gemstone(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }
  }
}