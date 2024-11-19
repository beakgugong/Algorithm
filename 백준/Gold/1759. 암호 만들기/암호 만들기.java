import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<String> answer = new ArrayList<>();
  static final String vowels = "aeiou";
  static int L,C;
  static char[] alpha;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    L = Integer.parseInt(stringTokenizer.nextToken());
    C = Integer.parseInt(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(br.readLine());
    alpha = new char[C];


    for (int i = 0; i < C; i++) {
      alpha[i] = stringTokenizer.nextToken().charAt(0);
    }
    Arrays.sort(alpha);

    dfs(0, 0, 0, "");
    for (String str : answer) {
      System.out.println(str);
    }
  }

  static void dfs(int current, int vowelCount, int consonantCount, String str) {
    if (str.length() == L) {
      if (vowelCount >= 1 && consonantCount >= 2) {
        answer.add(str);
      }
      return;
    }

    for (int i = current; i < C; i++) {
      if (vowels.indexOf(alpha[i]) >= 0) {
        dfs(i + 1, vowelCount + 1, consonantCount, str + alpha[i]);
      } else {
        dfs(i + 1, vowelCount, consonantCount + 1, str + alpha[i]);
      }
    }
  }
}