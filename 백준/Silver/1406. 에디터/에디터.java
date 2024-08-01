import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer stringBuffer = new StringBuffer(br.readLine());
    int command = Integer.valueOf(br.readLine());
    int cursor = stringBuffer.length();

    for (int i=0; i<command; i++){
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

      switch (stringTokenizer.nextToken()){
        case "L":
          if (cursor!=0) {
            cursor--;
          }
          break;
        case "D":
          if (cursor!=stringBuffer.length()) {
            cursor++;
          }
          break;
        case "B":
          if (cursor>0) {
            stringBuffer.deleteCharAt(cursor-1);
            cursor-=1;
          }

          break;
        case "P":
          String add = stringTokenizer.nextToken();
          stringBuffer.insert(cursor,add);
          if (cursor<stringBuffer.length())cursor+=1;
          break;
      }
    }
    System.out.println(stringBuffer);

  }
}