import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
  static int sister;
  static int subin;
  static int answer = 0;
  static int count = 0;
  static boolean[] visited = new boolean[100000+1];
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str= new StringTokenizer(bufferedReader.readLine());
    subin = Integer.valueOf(str.nextToken());
    sister = Integer.valueOf(str.nextToken());
    visited[subin] =true;
    bfs();

    System.out.println(answer);
    System.out.println(count);
  }
  static void bfs(){
    Queue<int[]> queue = new LinkedList<>();
    int[] start = {subin,0};
    queue.add(start);

    while (!queue.isEmpty()){
      int qsize = queue.size();
      for (int j =0; j<qsize; j++) {
        int[] current = queue.poll();
        if (current[0] == sister){
          count++;
          answer = current[1];
        }
        visited[current[0]] = true;
        for (int i = 0; i < 3; i++) {
          int nextLocation = calculate(i, current[0]);

          if (nextLocation < 0 || nextLocation > 100000 || visited[nextLocation])
            continue;
          queue.add(new int[]{nextLocation, current[1] + 1});
        }
      }
      if (count!=0)return;

    }
  }
  static int calculate(int i,int current){
    if(i==0){
      return current+1;
    }
    else if (i==1){
      return current-1;
    }
    else return current*2;
  }
}