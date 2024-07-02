import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer;

    for (int i=0; i<T; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      Long N = Long.valueOf(stringTokenizer.nextToken());
      Long S = Long.valueOf(stringTokenizer.nextToken());
      Long E = Long.valueOf(stringTokenizer.nextToken());

      if ((N==S&&E==1)||(N==E&&S==1)){
        System.out.println(0);
      } else if (S == 1 || S==N || Math.abs(S-E)==1) {
        System.out.println(1);
      } else {
        System.out.println(2);
      }
    }
  }
}