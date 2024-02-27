import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Character, Integer> map = new HashMap<>();
    Character[] ALPHA = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    String str = br.readLine();
    int len = str.length();

    for(int i=0; i<len; i++){
      if(!map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), 1);
      }
      else
        map.put(str.charAt(i), map.get(str.charAt(i))+1);
    }

    int even = 0;
    int odd = 0;
    for(Character key : map.keySet()){
      if(map.get(key)%2==0){
        even++;
      }
      else odd++;
      if (odd > 1) {
        System.out.println("I'm Sorry Hansoo");
        return;
      }
    }
    if (len % 2 == 0 && odd > 0) {
      System.out.println("I'm Sorry Hansoo");
    } else if (len%2!=0 && odd<1) {
      System.out.println("I'm Sorry Hansoo");
    }

    StringBuffer stringBuffer = new StringBuffer();
    char mid = '0';

    for(int i=0; i<ALPHA.length; i++){
      if(map.containsKey(ALPHA[i])&& map.get(ALPHA[i])>1){
        for (int j=0; j<map.get(ALPHA[i])/2; j++) {
          stringBuffer.append(ALPHA[i]);
        }
      }
      if(map.containsKey(ALPHA[i])&& map.get(ALPHA[i])%2==1){
        mid = ALPHA[i];
      }
    }
    StringBuffer reverse = new StringBuffer(stringBuffer);

    if(mid > '0') {
      reverse.append(mid).append(stringBuffer.reverse());
    }
    else reverse.append(stringBuffer.reverse());
    System.out.println(reverse);
  }
}