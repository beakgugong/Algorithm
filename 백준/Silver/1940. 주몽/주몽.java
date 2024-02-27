import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int M = Integer.valueOf(br.readLine());
    String[] strings = br.readLine().split(" ");
    int answer = 0;

    for (int i=0; i<N; i++){
      for(int j=i+1; j<N; j++){
        if(Integer.valueOf(strings[i])+Integer.valueOf(strings[j])==M){
          answer++;
        }
      }
    }
    System.out.println(answer);
  }
}