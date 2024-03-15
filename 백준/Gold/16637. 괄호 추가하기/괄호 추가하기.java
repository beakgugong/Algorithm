import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
  static char[] chars;
  static int N;
  static int max = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(bufferedReader.readLine());
    String str= bufferedReader.readLine();
    chars = str.toCharArray();

    dfs(2,chars[0]-'0');

    System.out.println(max);
  }
  static void dfs(int i, int result){
    if (i>=N){
      max = Math.max(max,result);
      return;
    }

    dfs(i+2, calculate(result,chars[i]-'0',chars[i-1]));
    if(i+2<N) {
      int first = calculate(chars[i]-'0', chars[i + 2]-'0', chars[i + 1]);
      dfs(i + 4, calculate(result,first, chars[i-1]));
    }
  }
  static int calculate(int one, int two, char operate){
    if(operate=='+'){
      return one+two;
    }
    else if (operate=='-'){
      return one-two;
    }
    else return one*two;
  }
}