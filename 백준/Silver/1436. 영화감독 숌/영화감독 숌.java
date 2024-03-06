import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());
    int count = 0;
    int six = 666;

    while (true){
      if(String.valueOf(six).contains("666")){
        count++;
      }
      if (count == N) {
        System.out.println(six);
        return;
      }
      six++;
    }
  }

}