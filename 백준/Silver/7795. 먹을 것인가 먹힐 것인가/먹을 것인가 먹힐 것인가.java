import java.io.*;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int j=0; j<T; j++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int aSize = Integer.parseInt(st.nextToken());
      int bSize = Integer.parseInt(st.nextToken());
      int[] a = new int[aSize];
      int[] b = new int[bSize];
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < aSize; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < bSize; i++) {
        b[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(b);

      int answer = 0;
      for (int i=0; i<aSize; i++) {

        int low = 0;
        int high = bSize - 1;
        int count = 0;

        while (low <= high) {
          int mid = (low + high) / 2;

          if (a[i] > b[mid]) {
            low = mid + 1;
            count = low;
          }else if (a[i] <= b[mid]) {
            high = mid - 1;
          }
        }
        answer+=count;
      }
      System.out.println(answer);
    }
  }
}