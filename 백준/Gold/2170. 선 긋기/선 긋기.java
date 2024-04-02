import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    List<int[]> list = new ArrayList<>();

    for (int i=0; i<N; i++){
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      int x = Integer.valueOf(stringTokenizer.nextToken());
      int y = Integer.valueOf(stringTokenizer.nextToken());
      list.add(new int[]{x,y});
    }

    Collections.sort(list, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0]==o2[0]){
          return o1[1]-o2[1];
        }
        return o1[0]-o2[0];
      }
    });

    int answer = 0;
    int head = list.get(0)[0];
    int tail = list.get(0)[1];

    for (int i=1; i<list.size(); i++){
      int x = list.get(i)[0];
      int y = list.get(i)[1];
      if (x<tail){
        if (y>tail){
          tail = y;
        }
      }
      else {
        answer+= (tail-head);
        head = x;
        tail = y;
      }
    }
    answer+=(tail-head);
    System.out.println(answer);
  }
}