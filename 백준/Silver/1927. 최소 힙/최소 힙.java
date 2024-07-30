import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringBuffer stringBuffer = new StringBuffer();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1-o2;
      }
    });

    for (int i=0; i<N; i++){
      int tmp = Integer.valueOf(br.readLine());

      if (tmp!=0){
        priorityQueue.add(tmp);
      }
      else {
        if (priorityQueue.peek()==null){
          stringBuffer.append(0+"\n");
        }
        else {
          stringBuffer.append(priorityQueue.poll() + "\n");
        }
      }
    }

    System.out.println(stringBuffer);
  }
}