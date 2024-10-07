import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken());
    int M = Integer.valueOf(st.nextToken());
    int[] minute = new int[N];
    int sum = 0;
    int answer = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      minute[i] = Integer.valueOf(st.nextToken());
      sum += minute[i];
    }


    int low = 1;
    int high = sum;

    while (low <= high) {
      int mid = (low + high) / 2;

      int count = 0;
      int blueLay = 0;

      for (int i=0; i<minute.length; i++) {
        if (minute[i]>mid){
          blueLay = M+1;
          break;
        }

        count += minute[i];

        if (count>mid){
          blueLay++;
          count = minute[i];
        }else if (count==mid){
          blueLay++;
          count = 0;
        }
      }

      if (count<mid&&count!=0){
        blueLay++;
      }

      if (blueLay>M){
        low = mid+1;
      } else if (blueLay<=M) {
        high = mid-1;
        answer = Math.min(answer, mid);
      }
    }
    System.out.println(answer);
  }
}