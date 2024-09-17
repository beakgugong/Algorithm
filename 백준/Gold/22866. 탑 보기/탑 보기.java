import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
  static int N;
  static List<Integer> arr;
  static int[] near;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    arr = new ArrayList<>();
    near = new int[N];
    int[] merge = new int[N];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<N; i++){
      arr.add(Integer.valueOf(stringTokenizer.nextToken()));
    }


    int[] forward = singleDirection(true);
    Collections.reverse(arr);
    int[] backward = singleDirection(false);

    for(int i=0; i<N; i++){
      merge[i] = forward[i]+backward[N-1-i];
    }


    for(int i=0; i<N; i++){
      if (merge[i]!=0){
        stringBuffer.append(merge[i]+" "+near[i]+"\n");
      }else stringBuffer.append(0+"\n");
    }
    System.out.println(stringBuffer);
  }
  static int[] singleDirection(boolean flag){

    Stack<Integer> stack  = new Stack<>();
    stack.add(0);
    int[] store = new int[N];

    for (int i=1; i<N; i++){
      if (arr.get(stack.peek())>arr.get(i)){
        store[i] = store[stack.peek()]+1;
        if (store[i]!=0){
          if (flag&&near[i]==0) {
            near[i] = stack.peek()+1;
          }else if ((!flag&&near[N-i-1]==0)||(!flag&&i-stack.peek()<N-i-near[N-i-1])){
            near[N-i-1] = N-stack.peek();
          }
        }
        stack.add(i);
      }
      else {
        while (!stack.isEmpty()&&arr.get(stack.peek())<=arr.get(i)){
          stack.pop();
        }
        try {
          store[i] = store[stack.peek()]+1;
        }catch (EmptyStackException e ){
          store[i] = 0;
        }finally {
          if (store[i]!=0){
            if (flag&&near[i]==0) {
              near[i] = stack.peek()+1;
            }else if ((!flag&&near[N-i-1]==0)||(!flag&&i-stack.peek()<N-i-near[N-i-1])){
              near[N-i-1] = N-stack.peek();
            }
          }
          stack.add(i);
        }
      }
    }
    return store;
  }
}