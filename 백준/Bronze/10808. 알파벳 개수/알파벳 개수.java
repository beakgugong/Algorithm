import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String word = br.readLine();
  int[] answer = new int[26];
  char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

  for (int j=0; j<word.length(); j++) {
    for (int i = 0; i < answer.length; i++) {
      if(word.charAt(j)==alpha[i]){
        answer[i]++;
        break;
      }
    }
  }
  for (int i : answer) {
    System.out.print(i+" ");
  }
  br.close();

  }

}