import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());

    int stomachache = 0;
    int answer = 0;
    while (stringTokenizer.hasMoreTokens()){
      stomachache+=Integer.valueOf(stringTokenizer.nextToken());
      if (stomachache<0)stomachache=0;
      if (stomachache>=M){
        answer++;
      }
    }
    System.out.println(answer);
  }
}