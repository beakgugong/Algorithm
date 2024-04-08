import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    for (int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.valueOf(st.nextToken());
      int M = Integer.valueOf(st.nextToken());
      ArrayList<Integer> arrayListA = new ArrayList<>();
      ArrayList<Integer> arrayListB = new ArrayList<>();
      st = new StringTokenizer(br.readLine());

      for (int j=0; j<N; j++){
        arrayListA.add(Integer.valueOf(st.nextToken()));
      }

      st = new StringTokenizer(br.readLine());
      for (int k=0; k<M; k++){
        arrayListB.add(Integer.valueOf(st.nextToken()));
      }

      Collections.sort(arrayListA);
      Collections.sort(arrayListB);

      int count = 0;

      for (int j=0; j<N; j++){
        int A = arrayListA.get(j);
        int low = 0;
        int high = arrayListB.size()-1;
        int tmp = -1;
        while (low<=high) {
          int mid = (high+low)/2;
          if (arrayListB.get(mid) >= A) {
            high = mid-1;
          }
          else {
            low = mid+1;
            tmp = Math.max(mid,tmp);
          }
        }
        count+=(tmp+1);
      }
      System.out.println(count);
    }
  }
}
