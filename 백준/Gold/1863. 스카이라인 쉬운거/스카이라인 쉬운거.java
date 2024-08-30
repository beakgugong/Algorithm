import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer;
    Stack<Integer> stack = new Stack<>();
    Set<Integer> set = new HashSet<>();
    int answer = 0;
    stack.add(0);

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());

      if (y==0){
        answer += stackCount(stack);
        stack.clear();
      } else if (stack.peek()>y){
        while (!stack.isEmpty()){
          if (stack.peek()>y){
            set.add(stack.pop());
          }
          else {
            answer+= set.size();
            set.clear();
            break;
          }
        }
      }
      stack.add(y);
    }

    answer+=stackCount(stack);

    System.out.println(answer);
  }
  static <K> int stackCount(Stack<K> stack){
    Set<K> set = new HashSet<>();

    while (!stack.isEmpty()){
      set.add(stack.pop());
    }
    return set.size()-1;
  }
}