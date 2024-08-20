import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int x = Integer.valueOf(stringTokenizer.nextToken());
    int n = Integer.valueOf(stringTokenizer.nextToken());
    boolean[] visit = new boolean[100001];
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1]-o2[1];
      }
    });

    int tmp = x;
    int count = 0;
    visit[x] = true;
    queue.add(new int[]{x,0});

    while (tmp!=n) {
      tmp = queue.peek()[0];
      count = queue.peek()[1];
      queue.poll();
      visit[tmp] = true;

      if (tmp>0&&!visit[tmp-1]){
        queue.add(new int[]{tmp - 1, count + 1});
      }
      if (tmp<100000&&!visit[tmp+1]) {
        queue.add(new int[]{tmp + 1, count + 1});
      }
      if (tmp<n&&tmp!=0&&tmp*2<=100000) {
        queue.add(new int[]{tmp * 2, count});
      }
    }

    System.out.println(count);
  }
}