import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String str = br.readLine();

  int start = 0;
  int end = str.length()-1;

  for(int i=0; i<str.length()/2; i++){
    if(str.charAt(start)!=str.charAt(end)){
      System.out.println(0);
      return;
    }
    else {
      start++;
      end--;
    }
  }
  System.out.println(1);
  br.close();

  }

}