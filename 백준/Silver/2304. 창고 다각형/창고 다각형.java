import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer;
    ArrayList<int[]> arrayList = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int answer = 0;
    int[] tmp = new int[2];
    Stack<int[]> stack = new Stack<>();
    int index = 0;

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());

      arrayList.add(new int[]{x,y});
      if (max<=y){
        if (max==y&&tmp[0]<arrayList.get(i)[0]){
          max = y;
          tmp = arrayList.get(i);
          continue;
        } else if (max==y&&tmp[0]>arrayList.get(i)[0]) {
          continue;
        }
        max = y;
        tmp = arrayList.get(i);
      }
    }

    Collections.sort(arrayList, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });

    index = arrayList.indexOf(tmp);
    stack.add(arrayList.get(0));

    for (int i=1; i<=index; i++){
      if (stack.peek()[1]<=arrayList.get(i)[1]){
        answer+=(arrayList.get(i)[0]-stack.peek()[0])*stack.peek()[1];
        stack.add(arrayList.get(i));
      }
    }

    stack.clear();
    answer+=arrayList.get(index)[1];
    if (index!=N-1) {
      stack.add(arrayList.get(index + 1));
    }
    else{
      System.out.println(answer);
      return;
    }

    for (int i=index+2; i<N; i++){
      if (stack.peek()[1]<arrayList.get(i)[1]){
        while (!stack.isEmpty()&&stack.peek()[1]<arrayList.get(i)[1]){
          stack.pop();
        }
      }
      stack.add(arrayList.get(i));
    }

    int beforeX;
    int beforeY;
    int afterX;

    while (stack.size()>1){
      beforeX = stack.peek()[0];
      beforeY = stack.peek()[1];
      stack.pop();
      afterX = stack.peek()[0];
      answer += (beforeX-afterX)*beforeY;
    }

    beforeX = stack.peek()[0];
    beforeY = stack.peek()[1];

    answer += (beforeX-arrayList.get(index)[0])*beforeY;
    System.out.println(answer);
  }
}