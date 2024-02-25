import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int count = Integer.valueOf(br.readLine());
  String pattern = br.readLine();
  String str = pattern.substring(0,pattern.indexOf('*'));
  String str1 = pattern.substring(pattern.indexOf('*')+1);

  for(int i=0; i<count; i++){
    String tmp = br.readLine();
      
    if(tmp.length()<str.length()+str1.length()) {
      System.out.println("NE");
    }
    else {
      if (tmp.substring(0, str.length()).equals(str) &&
              tmp.substring(tmp.length() - str1.length()).equals(str1)) {
        System.out.println("DA");
      } else {
        System.out.println("NE");
      }
    }
    }
  }

}