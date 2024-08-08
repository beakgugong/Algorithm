import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    String str = br.readLine();
    int count = 0;
    int min = Integer.MAX_VALUE;
    int red = 0;
    int blue = 0;

    for (int i=0; i<str.length(); i++){
      if (str.charAt(i)=='R'){
        red++;
      }
      else {
        blue++;
      }
    }

    int point = 0;
    while (point<str.length()) {
      if (str.charAt(point)=='R'){
        count++;
        point++;
      }
      else break;
    }
    min = Math.min(min,red-count);
    point = 0;
    count=0;

    while (point<str.length()) {
      if (str.charAt(point)=='B'){
        count++;
        point++;
      }
      else break;
    }
    min = Math.min(min,blue-count);
    count=0;
    point = str.length()-1;

    while (point>-1) {
      if (str.charAt(point)=='R'){
        count++;
        point--;
      }
      else break;
    }

    min = Math.min(min,red-count);
    count=0;
    point = str.length()-1;
    while (point>-1) {
      if (str.charAt(point)=='B'){
        count++;
        point--;
      }
      else break;
    }
    min = Math.min(min,blue-count);

    System.out.println(min);
  }
}