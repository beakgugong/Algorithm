import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int H = Integer.valueOf(stringTokenizer.nextToken());
    int W = Integer.valueOf(stringTokenizer.nextToken());
    Queue<Character> queue = new LinkedList<>();

    for(int i=0; i<H; i++){
      String str = br.readLine();
      int cloud = 0;
      for(int j=0; j<W; j++){
        queue.add(str.charAt(j));
      }
      while (queue.size()!=0) {
        if(queue.poll()=='c'){
          cloud=0;
          System.out.print(cloud+" ");
          cloud++;
        }
        else {
          if(cloud>0){
            System.out.print(cloud+" ");
            cloud++;
          }
          else {
            System.out.print(-1+" ");
          }
        }
      }
      System.out.println();
    }
  }
}