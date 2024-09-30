import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    long answer = 0;
    PriorityQueue<Jam> arrayList = new PriorityQueue<>(new Comparator<Jam>() {
      @Override
      public int compare(Jam o1, Jam o2) {
        return o1.weight-o2.weight;
      }
    });
    PriorityQueue<Integer> bag = new PriorityQueue<>();
    PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int weight = Integer.valueOf(stringTokenizer.nextToken());
      int price = Integer.valueOf(stringTokenizer.nextToken());

      arrayList.add(new Jam(weight,price));
    }
    for (int i = 0; i < K; i++) {
      bag.add(Integer.valueOf(br.readLine()));
    }

    while (!bag.isEmpty()) {
      int b = bag.poll();

      while (!arrayList.isEmpty()&&b>=arrayList.peek().weight) {
        tmp.add(arrayList.poll().price);
      }
      if (!tmp.isEmpty()) {
        answer += tmp.peek();
        tmp.poll();
      }
    }
    System.out.println(answer);
  }
  static class Jam{
    int weight;
    int price;

    public Jam(int weight, int price){
      this.weight = weight;
      this.price = price;
    }
  }
}