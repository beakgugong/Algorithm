import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    StringTokenizer stringTokenizer;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        priorityQueue.add(Integer.valueOf(stringTokenizer.nextToken()));
      }
    }

    for (int i=0; i<N-1; i++){
      priorityQueue.poll();
    }

    System.out.println(priorityQueue.peek());

  }
}