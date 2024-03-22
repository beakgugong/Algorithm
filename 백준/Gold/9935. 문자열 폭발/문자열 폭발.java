import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer str = new StringBuffer(br.readLine());
    StringBuffer answer = new StringBuffer();
    String boom = br.readLine();

    for (int i=0; i<str.length(); i++) {
      answer.append(str.charAt(i));
      if (answer.length()>=boom.length()&&answer.substring((answer.length()-boom.length()),answer.length()).equals(boom)){
        answer.delete(answer.length()-boom.length(),answer.length());
      }
    }
    if (answer.length() == 0) {
      System.out.println("FRULA");
    } else {
      System.out.println(answer);
    }
  }
}