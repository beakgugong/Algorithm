import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int sum = 0;
    int waiting = 0;

    for (int i = 0; i < N; i++) {
      priorityQueue.add(Integer.parseInt(stringTokenizer.nextToken()));
    }

    while (!priorityQueue.isEmpty()) {
      waiting += priorityQueue.poll();
      sum += waiting;
    }
    System.out.println(sum);
  }
}