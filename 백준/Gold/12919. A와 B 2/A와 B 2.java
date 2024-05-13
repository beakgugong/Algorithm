import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static boolean flag;
  static Map<String, Integer> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();
    map = new HashMap<>();

    dfs(S, T);

    if (flag) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  static void dfs(String S, String T) {
    if (T.length() == S.length()) {
      if (S.equals(T)) {
        flag = true;
      }
      return;
    }

    StringBuffer stringBuffer = new StringBuffer(S);
    stringBuffer.append("A");
    if (T.contains(stringBuffer)) {
      dfs(stringBuffer.toString(),T);
    }
    else if (T.contains(stringBuffer.reverse())){
      dfs(stringBuffer.reverse().toString(),T);
    }

    StringBuffer stringBuffer1 = new StringBuffer(S);
    stringBuffer1.append("B").reverse();
    if (T.contains(stringBuffer1)) {
      dfs(stringBuffer1.toString(),T);
    }
    else if (T.contains(stringBuffer1.reverse())){
      dfs(stringBuffer1.reverse().toString(),T);
    }
    return;
  }
}
