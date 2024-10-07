import java.io.*;
import java.util.*;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    boolean[] visited = new boolean[N+1];
    int[] parent = new int[N+1];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i <= N; i++) {
      matrix.add(new ArrayList<>());
    }

    for (int i = 0; i < N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      matrix.get(a).add(b);
      matrix.get(b).add(a);
    }

    queue.add(1);
    visited[1] = true;

    while (!queue.isEmpty()){
      int i = queue.poll();

      for (int j=0; j< matrix.get(i).size(); j++){
        int next = matrix.get(i).get(j);

        if (visited[next]){
          continue;
        }
        queue.add(next);
        parent[next] = i;
        visited[next] = true;
      }
    }

    StringBuffer stringBuffer = new StringBuffer();

    for (int i=2; i<=N; i++){
      stringBuffer.append(parent[i]+"\n");
    }
    System.out.println(stringBuffer);
  }
}