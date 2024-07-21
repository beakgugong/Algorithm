import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int X = Integer.valueOf(stringTokenizer.nextToken());
    int count = 1;
    int max = 0;
    int[] prefix = new int[N];
    stringTokenizer = new StringTokenizer(br.readLine());
    prefix[0] = Integer.valueOf(stringTokenizer.nextToken());

    for (int i=1; i<N; i++){
      prefix[i] = prefix[i-1]+Integer.valueOf(stringTokenizer.nextToken());
    }
    max = prefix[X-1];

    for (int i=X; i<N; i++){
      int tmp = prefix[i]-prefix[i-X];
      if (max<tmp){
        max = tmp;
        count = 1;
      } else if(max==tmp){
        count++;
      }

    }
    if (max==0){
      System.out.println("SAD");
      return;
    }
    System.out.println(max);
    System.out.println(count);

  }
}