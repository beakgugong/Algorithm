import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Character> que = new LinkedList<>();
    char ja = 'j';
    char mo = 'm';
    boolean print;

    while (true) {
      String str = br.readLine();
      if(str.equals("end"))break;
      print = false;

      if(str.indexOf('a')>-1||str.indexOf('e')>-1||str.indexOf('i')>-1||
              str.indexOf('o')>-1||str.indexOf('u')>-1){
      }
      else {
        System.out.println("<" + str + ">" + " is not acceptable.");
        continue;
      }

      for (int i=0; i<str.length(); i++) {
        if(estimate(str.charAt(i))){
          que.add(mo);
        }
        else que.add(ja);
      }
      int moCount = 0;
      int jaCount = 0;
      while (que.size()!=0){
        if((que.peek()==mo&&jaCount>0)||que.peek()==mo){
          jaCount=0;
          moCount++;
        }
        else if((que.peek()==ja&&moCount>0)||que.peek()==ja){
          moCount=0;
          jaCount++;
        }
        que.poll();
        if(jaCount==3||moCount==3){
          System.out.println("<" + str + ">" + " is not acceptable.");
          print = true;
          break;
        }
      }
      que.clear();
      if (print)continue;
      if(!sequence(str)) {
        System.out.println("<" + str + ">" + " is not acceptable.");
        continue;
      }
      System.out.println("<"+str+">"+" is acceptable.");
    }
  }
  static boolean estimate(char c){
    if(c=='a'||c=='e'||c=='i'|| c=='o'||c=='u'){
      return true;
    }
    return false;
  }
  static boolean sequence(String str){
    Queue<Character> que = new LinkedList<>();
    for(int i=0; i<str.length(); i++){
      que.add(str.charAt(i));
    }
    while (que.size()!=1){
      char tmp = que.poll();
      if(tmp==que.peek()&&(tmp!='e'&&tmp!='o')){
        return false;
      }
    }
    return true;
  }
}