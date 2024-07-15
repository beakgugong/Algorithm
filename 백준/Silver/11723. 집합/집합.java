import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
  static Set<Integer> set = new HashSet<>();
  static StringBuffer stringBuffer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer;
    stringBuffer = new StringBuffer();

    for (int i=0; i<M; i++){
       stringTokenizer = new StringTokenizer(br.readLine());
       String method = stringTokenizer.nextToken();
       int x = 0;
       if (!method.equals("all")&&!method.equals("empty")){
         x = Integer.valueOf(stringTokenizer.nextToken());
       }

       switch (method){
         case "add" :add(x);
           break;
         case "check" : check(x);
           break;
         case "remove" : remove(x);
           break;
         case "all" : all();
           break;
         case "empty" : empty();
           break;
         case "toggle" : toggle(x);
           break;
       }
    }
    System.out.println(stringBuffer);

  }
  static void add(int x){
    if (set.contains(x)){
      return;
    }
    set.add(x);
  }
  static void check(int x){

    if (set.contains(x)) {
      stringBuffer.append(1+"\n");
    } else {
      stringBuffer.append(0+"\n");
    }
  }
  static void remove(int x){
    if (set.contains(x)){
      set.remove(x);
    }
  }
  static void toggle(int x){
    if (set.contains(x)){
      set.remove(x);
    }
    else {
      set.add(x);
    }
  }
  static void all(){
    for (int i=1; i<=20; i++){
      set.add(i);
    }
  }
  static void empty(){
    set.clear();
  }
}