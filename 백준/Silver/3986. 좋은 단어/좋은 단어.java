import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.valueOf(br.readLine());
    int answer = 0;
    Stack<Character> stack = new Stack<>();

    for(int i=0; i<num; i++){
      String str = br.readLine();

      if(str.length()%2!=0){
        continue;
      }
      for(int j=0; j<str.length(); j++){
        if(stack.size()!=0&&stack.peek()==str.charAt(j)){
          stack.pop();
        }
        else
          stack.push(str.charAt(j));
      }
      if(stack.size()==0){
       answer++;
      }
      stack.clear();
    }
    System.out.println(answer);
  }
}