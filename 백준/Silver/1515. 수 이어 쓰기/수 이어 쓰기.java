import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    char[] arr = str.toCharArray();
    int pointer = 1;

    for (int i=0; i<arr.length; i++){
      while (true) {
        if (String.valueOf(pointer).contains(String.valueOf(arr[i]))) {
          int idx = String.valueOf(pointer).indexOf(String.valueOf(arr[i]));
          String tmp = String.valueOf(pointer).substring(idx+1);
          int count = 1;
          while (i+count<arr.length&&tmp.contains(String.valueOf(arr[i+count]))) {
            idx = tmp.indexOf(String.valueOf(arr[i+count]));
            tmp = tmp.substring(idx+1);
            count++;
          }
          i+=count-1;
          pointer++;
          break;
        }
        pointer++;
      }
    }
    System.out.println(pointer-1);

  }
}