import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int a = Integer.valueOf(st.nextToken());
    int b = Integer.valueOf(st.nextToken());
    int height = Math.max(a,b);
    Deque<Integer> queue = new ArrayDeque<>();

    for (int i=1; i<b; i++){
      queue.add(i);
    }
    queue.add(height);
    for (int i=a-1; i>0; i--){
      queue.add(i);
    }

    if (queue.size()>N){
      System.out.println(-1);
      return;
    }

    int tmp = queue.pollLast();
    if (queue.size()<N-1){
      while (queue.size()!=N-1){
        queue.addLast(1);
      }
    }
    queue.addLast(tmp);
    while (!queue.isEmpty()){
      System.out.print(queue.pollLast()+" ");
    }
  }
}