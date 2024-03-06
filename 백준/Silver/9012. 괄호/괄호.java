import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bufferedReader.readLine());

    for (int i=0; i<N; i++){
      String str = bufferedReader.readLine();
      Queue<Character> queue = new LinkedList<>();
      int right = 0;
      int left = 0;

      for(int j=0; j<str.length(); j++){
        queue.add(str.charAt(j));
      }
      do {
        if (queue.poll() == '(') {
          right++;
        } else {
          left++;
        }
        if (left > right) {
          System.out.println("NO");
          break;
        }
        if (queue.size()==0&&left==right){
          System.out.println("YES");
        }
        else if (queue.size()==0&&left!=right){
          System.out.println("NO");
        }
      }while ((queue.size() != 0));
    }
  }
}