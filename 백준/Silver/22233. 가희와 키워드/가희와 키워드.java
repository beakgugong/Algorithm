import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    HashSet<String> hashSet = new HashSet<>();
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<N; i++){
      hashSet.add(br.readLine());
    }

    for (int i=0; i<M; i++){
      String[] strings = br.readLine().split(",");

      for (int j=0; j<strings.length; j++){
        if (hashSet.contains(strings[j]));
        hashSet.remove(strings[j]);
      }
      stringBuffer.append(hashSet.size()+"\n");
    }
    System.out.println(stringBuffer);
  }
}