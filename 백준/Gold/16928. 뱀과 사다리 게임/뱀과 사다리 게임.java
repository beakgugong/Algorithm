import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int[] map = new int[101];
    boolean[] visit = new boolean[101];
    Queue<int[]> queue = new LinkedList<>();

    for (int i=0; i<101; i++){
      map[i] = i;
    }

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      map[Integer.valueOf(stringTokenizer.nextToken())] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      map[Integer.valueOf(stringTokenizer.nextToken())] = Integer.valueOf(stringTokenizer.nextToken());
    }

    queue.add(new int[]{1,0});
    visit[1] = true;

    while (!queue.isEmpty()){
      int location = map[queue.peek()[0]];
      int count = queue.peek()[1];
      queue.poll();

      if (map[location]>=100){
        System.out.println(count);
        return;
      }
      for (int i=1; i<7; i++){
        int nLocation = location+i;

        if (nLocation>99){
          System.out.println(count+1);
          return;
        }

        if (visit[nLocation]){
          continue;
        }
        queue.add(new int[]{nLocation,count+1});
        visit[nLocation] = true;
      }
    }
  }
}