import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    StringBuilder stringBuilder = new StringBuilder();

    for (int i=0; i<T; i++){
      stringBuilder = new StringBuilder();
      int N = Integer.valueOf(br.readLine());
      Map<Integer,Integer> map = new HashMap<>();
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


      for (int j=0; j<N; j++){
        map.put(Integer.valueOf(stringTokenizer.nextToken()),1);
      }

      int M = Integer.valueOf(br.readLine());
      stringTokenizer = new StringTokenizer(br.readLine());


      for (int j=0; j<M; j++) {
        int tmp = Integer.valueOf(stringTokenizer.nextToken());
        if (map.containsKey(tmp)){
          stringBuilder.append("1\n");
        } else {
          stringBuilder.append("0\n");
        }
      }
      System.out.print(stringBuilder);
    }
  }
}
