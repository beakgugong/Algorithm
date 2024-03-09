import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    Arrays.fill(answer,-1);

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());

      while (stack.size()>0&&arr[stack.peek()]<arr[i]){
        answer[stack.peek()] = arr[i];
        stack.pop();
      }
      stack.push(i);
    }
    
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.append(answer[i]);
      sb.append(" ");
    }
    System.out.println(sb);
  }
}