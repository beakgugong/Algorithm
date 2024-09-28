import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());

    for (int i = 0; i < N; i++) {
      int matchesCount = Integer.parseInt(br.readLine());

      long[] dpMin = new long[101];

      Arrays.fill(dpMin, Long.MAX_VALUE);
      dpMin[2] = 1;
      dpMin[3] = 7;
      dpMin[4] = 4;
      dpMin[5] = 2;
      dpMin[6] = 6;
      dpMin[7] = 8;
      dpMin[8] = 10;

      String[] add = {"1", "7", "4", "2", "0", "8"};

      for (int j = 9; j <= 100; j++) {
        for (int k = 2; k <= 7; k++) {
          String line = "" + dpMin[j - k] + add[k - 2];
          dpMin[j] = Math.min(Long.parseLong(line), dpMin[j]);
        }
      }
      

      StringBuilder max = new StringBuilder();
      long a = matchesCount / 2;
      long b = matchesCount % 2;
      if (b == 1) {
        max.append("7");
      } else {
        max.append("1");
      }

      for (int j = 1; j < a; j++) {
        max.append("1");
      }
      System.out.println(dpMin[matchesCount] + " " + max.toString());

    }
  }
}