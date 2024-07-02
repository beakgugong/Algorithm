import java.io.*;
import java.util.*;

public class Main {
  static StringBuffer num1 = new StringBuffer();
  static StringBuffer num2 = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());

    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    makeNum(stringTokenizer,num1);
    stringTokenizer = new StringTokenizer(br.readLine());
    makeNum(stringTokenizer,num2);

    System.out.println(Math.min(Long.valueOf(num1.toString()),Long.valueOf(num2.toString())));

  }
  static void makeNum(StringTokenizer stringTokenizer,StringBuffer stringBuffer){
    while (stringTokenizer.hasMoreTokens()) {
      stringBuffer.append(stringTokenizer.nextToken());
    }
  }
}