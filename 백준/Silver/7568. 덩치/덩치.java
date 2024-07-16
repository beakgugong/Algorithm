import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] height = new int[N];
    int[] weight = new int[N];
    int[] rank = new int[N];
    StringTokenizer stringTokenizer;


    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      height[i] = Integer.valueOf(stringTokenizer.nextToken());
      weight[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<N; i++){
      int count = 1;
      for (int j=0; j<N; j++){
        if (height[i]<height[j]&&weight[i]<weight[j]){
          count++;
        }
      }
      rank[i] = count;
    }

    StringBuffer stringBuffer = new StringBuffer();
    for (int i : rank){
      stringBuffer.append(i+" ");
    }
    System.out.println(stringBuffer);
  }
}