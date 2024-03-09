import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(bufferedReader.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    Stack<Integer> stack = new Stack<>();
    int[] arr = new int[N];
    int[] answer = new int[N];

    for (int i = 0; i < N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    for (int i=N-1; i>-1; i--){
      if (stack.isEmpty()){
        answer[i] = -1;
        stack.add(arr[i]);
        continue;
      }
      if (stack.peek()>arr[i]){
        answer[i] = stack.peek();
        stack.add(arr[i]);
      }
      else {
        stack.pop();
        i++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.append(answer[i]);
      sb.append(" ");
    }
    System.out.println(sb);
  }
}
