import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int people = Integer.parseInt(br.readLine());
  Map<Character,Integer> map = new HashMap<>();
  StringBuffer str = new StringBuffer();

  for(int i=0; i<people; i++){
    Character firstName = br.readLine().charAt(0);
    try {
      map.put(firstName,map.get(firstName)+1);
    }
    catch (NullPointerException e){
      map.put(firstName,1);
    }
  }
  for(Character character : map.keySet()){
    if(map.get(character)>=5){
      str.append(character);
    }
  }
  if (str.length() == 0) {
    System.out.println("PREDAJA");
    return;
  }
  System.out.println(str);
  br.close();

  }

}