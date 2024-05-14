import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,1};
  static int W,H;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    Stack<Integer> stack = new Stack<>();

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    stack.push(0);
    stack.push(0);
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(0+" ");

    for (int i=1; i<N; i++){
      if (arr[stack.peek()]>arr[i]){
        stringBuffer.append(stack.peek()+1+" ");
        stack.push(i);
      }
      else {
        while (stack.size()>1){
          stack.pop();
          if (arr[stack.peek()]>arr[i]){
            stringBuffer.append(stack.peek()+1+" ");
            stack.push(i);
            break;
          }
        }
      }
      if (stack.size()==1){
        stringBuffer.append(0+" ");
        stack.push(i);
      }
    }
    System.out.println(stringBuffer);
  }
}
