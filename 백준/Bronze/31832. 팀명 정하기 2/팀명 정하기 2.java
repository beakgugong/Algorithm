import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());

    for (int i=0; i<N; i++){
      boolean flag;
      String str = br.readLine();
      flag = number(str);
      if (flag){
        continue;
      }
      flag = upperCase(str);
      if (flag){
        continue;
      }
      if (str.length()>10){
        continue;
      }
      System.out.println(str);
      return;
    }
  }
  public static boolean number(String str){

    int numCount = 0;
    for (int i=0; i<str.length(); i++){
       if (str.charAt(i)-48>=0&&str.charAt(i)-48<10){
         numCount++;
       }
    }
    if (numCount==str.length()){
      return true;
    }
    return false;
  }
  public static boolean upperCase(String str){
    int upper = 0;
    int down = 0;

    for (int i=0; i<str.length(); i++){
      if (str.charAt(i)>64&&str.charAt(i)<91){
        upper++;
      }
      else if (str.charAt(i)>96&&str.charAt(i)<123){
        down++;
      }
    }
    if (upper>down){
      return true;
    }
    return false;
  }
}