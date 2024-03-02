import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int J = Integer.valueOf(br.readLine());
    int min = 1;
    int move = 0;


    for(int i=0; i<J; i++) {
      int location = Integer.valueOf(br.readLine());
      if (location <= M && location >= min) {
        continue;
      } else if (location < min) {
        while (true) {
          min--;
          move++;
          M--;
          if (min == location)
            break;
        }
      } else if (location > M) {
        while (true) {
          min++;
          move++;
          M++;
          if (M == location)
            break;
        }
      }
    }
    System.out.println(move);
  }
}
