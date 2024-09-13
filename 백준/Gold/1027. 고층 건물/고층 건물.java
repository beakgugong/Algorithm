import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    int answer = Integer.MIN_VALUE;

    for (int i=0; i<N; i++){
      arr[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<N; i++){
      int one = i-1;
      float oneBefore = Integer.MAX_VALUE;
      int two = i+1;
      float twoBefore = Integer.MIN_VALUE;
      int count = 0;

        while (one>-1||two<N){

          if (one>-1&&oneBefore>(float)(arr[i]-arr[one])/(float)(i-one)){
            oneBefore = (float)(arr[i]-arr[one])/(float)(i-one);
            count++;
          }

          if (two<N&&twoBefore<(float)(arr[two]-arr[i])/(float)(two-i)){
            twoBefore = (float)(arr[two]-arr[i])/(float)(two-i);
            count++;
          }
          
          one--;
          two++;

      }
        answer = Math.max(answer,count);
    }
    System.out.println(answer);
  }
}