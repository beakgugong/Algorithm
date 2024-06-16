import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] cases = new int[N];
    long answer = 0;
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=0; i<N; i++){
      cases[i] = Integer.valueOf(stringTokenizer.nextToken());
      answer++;
    }
    stringTokenizer = new StringTokenizer(br.readLine());
    int B = Integer.valueOf(stringTokenizer.nextToken());
    int C = Integer.valueOf(stringTokenizer.nextToken());


    for (int i=0; i<cases.length; i++){
      int applyPeople = cases[i]-B;
      if (applyPeople<0){
        continue;
      }
      answer += applyPeople/C;
      if (applyPeople%C>0){
        answer++;
      }
    }
    System.out.println(answer);
  }
}