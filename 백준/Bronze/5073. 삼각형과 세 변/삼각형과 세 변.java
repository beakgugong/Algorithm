import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;

    while (true) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int a = Integer.valueOf(stringTokenizer.nextToken());
      int b = Integer.valueOf(stringTokenizer.nextToken());
      int c = Integer.valueOf(stringTokenizer.nextToken());
      int tmp = 0;

      if (a < b) {
        tmp = a;
        a = b;
        b = tmp;
      }
      if (a < c) {
        tmp = a;
        a = c;
        c = tmp;
      }
      if (a == 0 && b == 0 && c == 0) {
        return;
      }
      if (a >= b + c) {
        System.out.println("Invalid");
      } else if (a == b && b == c) {
        System.out.println("Equilateral");
      } else if (a == b || b == c || a == c) {
        System.out.println("Isosceles");
      } else if (a != b && b != c && a != c) {
        System.out.println("Scalene");
      }
    }
  }
}