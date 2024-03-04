import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    ArrayList<String> arrayList = new ArrayList<>();
    Queue<Character> queue = new LinkedList<>();
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<N; i++){
      String str = br.readLine();

      for(int j=0; j<str.length(); j++){
        queue.add(str.charAt(j));
      }
      queue.add('n');
      while (queue.size()!=0){

        if (queue.peek()-'0'>-1 && '9'-queue.peek()>-1){
          stringBuffer.append(queue.poll()-'0');
        }
        else {
          if (stringBuffer.length() > 0) {
            while(stringBuffer.length()>0&&stringBuffer.charAt(0)=='0'){
              stringBuffer.delete(0, 1);
            }
            if (stringBuffer.length()==0)arrayList.add("0");
            else arrayList.add(stringBuffer.toString());
            queue.poll();
          } else
            queue.poll();
          stringBuffer.delete(0, stringBuffer.length());
        }
      }
      stringBuffer.delete(0, stringBuffer.length());
    }

    arrayList.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length()==o2.length()){
          int num=0;
          try {
            while (Integer.valueOf(o1.charAt(num)) - Integer.valueOf(o2.charAt(num)) == 0) {
              num++;
            }
            return Integer.valueOf(o1.charAt(num)) - Integer.valueOf(o2.charAt(num));
          }
          catch (StringIndexOutOfBoundsException e){
            return o1.length()-o2.length();
          }
        }
        return o1.length()-o2.length();
      }
    });
    for (String i : arrayList){
      System.out.println(i);
    }
  }
}