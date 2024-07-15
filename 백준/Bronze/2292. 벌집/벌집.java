import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(br.readLine());
    int a = 2;
    int plusSix = 0;
    if (n==1){
      System.out.println(1);
      return;
    }
    while(a<=n){
      a+=(plusSix*6);
      plusSix++;
    }

    System.out.println(plusSix);

  }
}