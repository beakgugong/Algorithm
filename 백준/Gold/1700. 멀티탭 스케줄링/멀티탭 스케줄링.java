import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());
    int[] sequence = new int[K];
    boolean[] visit = new boolean[K+1];
    int answer = 0;

    for (int i=0; i<K; i++){
      int num = Integer.valueOf(stringTokenizer.nextToken());
      sequence[i] = num;
    }

    int size = 0;
    for (int i=0; i<K; i++){
      int tmp = sequence[i];

      if (!visit[tmp]){
        if (size<N){
          visit[tmp] = true;
          size++;
        }
        else {
          ArrayList<Integer> arrayList = new ArrayList<>();
          for (int j=i+1; j<K; j++){
            if (visit[sequence[j]]&&!arrayList.contains(sequence[j])){
              arrayList.add(sequence[j]);
            }
          }
          if (arrayList.size()<N){
            for (int j=0; j<K; j++){
              if (visit[j+1]&&!arrayList.contains(j+1)){
                visit[j+1]=false;
                break;
              }
            }
          }
          else {
            visit[arrayList.get(arrayList.size()-1)] = false;

          }
          answer++;
          visit[tmp] = true;
        }
      }
    }
    System.out.println(answer);
  }
}