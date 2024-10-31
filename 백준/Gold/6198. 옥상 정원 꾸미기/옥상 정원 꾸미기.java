import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer stringTokenizer;
    int[] building = new int[N];
    int[] viewCount = new int[N];
    Stack<Integer> stack = new Stack<>();
    long answer = 0;

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      building[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    viewCount[N-1] = 1;
    stack.add(N-1);
    for (int i = N-2; i >= 0 ; i--) {
      int sum = 0;
      while (!stack.isEmpty()&&building[stack.peek()] < building[i]) {
        if (viewCount[stack.peek()]==0) {
          sum += 1;
        }else {
          if (stack.peek() != N - 1)
            sum += 1;
          sum += viewCount[stack.peek()];
        }

        stack.pop();
      }

      viewCount[i] = sum;
      stack.add(i);
    }

    for (int i = 0; i < N-1; i++) {
      answer += viewCount[i];
    }
    System.out.println(answer);
  }
}