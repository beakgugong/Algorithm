import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String str = br.readLine();
  StringBuffer answer= new StringBuffer();

  for(int i=0; i<str.length(); i++){
    if(str.charAt(i)>=65&&str.charAt(i)<=90){
      answer.append(rot13(str.charAt(i)));
    } else if (str.charAt(i)>=97&&str.charAt(i)<=122) {
      answer.append(Rot13(str.charAt(i)));
    }
    else answer.append(str.charAt(i));
  }
  System.out.println(answer);
  br.close();

  }

  private static char Rot13(char c) {
    char rot;
    if(c+13>122){
      rot = (char) (c-13);
    }
    else {
      rot = (char) (c+13);
    }
    return rot;
  }

  public static char rot13(char cha){
  char rot;
    if(cha+13>90){
      rot = (char) (cha-13);
    }
    else {
      rot = (char) (cha+13);
    }
    return rot;
  }

}