import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int L;
  static List<int[]> list;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    L = Integer.valueOf(stringTokenizer.nextToken());
    list = new LinkedList<>();

    for (int i=0; i<N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int start = Integer.valueOf(stringTokenizer.nextToken());
      int end = Integer.valueOf(stringTokenizer.nextToken());

      list.add(new int[]{start,end});
    }

    Collections.sort(list, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });

    int answer = 0;
    int tail = 0;
    int nullfan = 0;

    for (int i=0; i<list.size(); i++){
      if (tail>=list.get(i)[0]){
        nullfan = tail;
      }
      else {
        nullfan = (list.get(i)[0] + L);
        answer++;
      }

      if (nullfan<list.get(i)[1]){
        int tmp = list.get(i)[1]-nullfan;
        int extra = tmp%L;
        tmp/=L;
        if (tmp==0){
          nullfan+=L;
          answer++;
        }
        else {
          if (extra==0) {
            nullfan += (tmp * L);
            answer += tmp;
          }
          else {
            nullfan += (tmp * L);
            nullfan += L;
            answer += (tmp+1);
          }
        }
      }
      tail = nullfan;

    }
    System.out.println(answer);

  }
}