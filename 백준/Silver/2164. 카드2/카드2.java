import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i=N; i>0; i--){
      deque.add(i);
    }

    while (deque.size()>1){
      deque.removeLast();
      int tmp = deque.getLast();
      deque.removeLast();
      deque.addFirst(tmp);
    }

    System.out.println(deque.getFirst());
 }
}