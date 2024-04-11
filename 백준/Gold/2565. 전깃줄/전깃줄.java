import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    int n = Integer.valueOf(br.readLine());
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.valueOf(stringTokenizer.nextToken());
      arr[i][1] = Integer.valueOf(stringTokenizer.nextToken());
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });

    int[] dp = new int[n];
    int length = 0;

    for (int i = 0; i < n; i++) {
      int pos = Arrays.binarySearch(dp, 0, length, arr[i][1]);
      if (pos < 0) {
        pos = -pos - 1;
      }
      dp[pos] = arr[i][1];
      if (pos == length) {
        length++;
      }
    }

    System.out.println(n - length);
  }
}