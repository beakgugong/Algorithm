import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] cards = new int[N];
    StringBuffer sb = new StringBuffer();

    for (int i=0; i<N; i++) {
      cards[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    int[] numbers = new int[M];
    stringTokenizer = new StringTokenizer(br.readLine());
    Arrays.sort(cards);

    for (int i=0; i<M; i++) {
      numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    for (int i=0; i<M; i++) {
      int low = 0;
      int high = N-1;
      boolean flag = false;

      while (low <= high) {
        int mid = (low + high)/2;

        if (cards[mid] > numbers[i]) {
          high = mid - 1;
        } else if (cards[mid] < numbers[i]) {
          low = mid + 1;
        }else {
          flag = true;
          break;
        }
      }

      if (flag) {sb.append(1+" ");}
      else {sb.append(0+" ");};
    }
    System.out.println(sb.toString());


  }
}