import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    char[] arr =new char[N];
    String str = br.readLine();
    String tmp = br.readLine();
    char origin;
    char answer = tmp.charAt(0);

    for (int i=0; i<N; i++) {
      arr[i] = str.charAt(i*2);
    }
    origin = arr[N-1];

    if (N==1){
      if(arr[0]==answer){
        System.out.println(0);
        return;
      }
      else {
        System.out.println(1);
        return;
      }
    }

    for (int i=1; i<N; i+=2){
      if (calculate(arr[i-1],arr[i+1], arr[i])){
        arr[i+1] = 'T';
      }
      else arr[i+1] = 'F';
    }

    char lastC = arr[N-1];
    char lastOperate = arr[N-2];
    char secondLastC = arr[N-3];
    if (lastC==answer){
      System.out.println(0);
      return;
    }
    changeCount(origin,lastOperate,secondLastC);

  }
  static void changeCount(char lastC, char lastOperate, char secondLastC){
    switch (lastOperate){
      case '&':
        if (lastC == 'T' || secondLastC == 'T') {
          System.out.println(1);
          break;
        } else {
          System.out.println(2);
          break;
        }
      case '|':
        if (lastC == 'F' || secondLastC == 'F') {
          System.out.println(1);
          break;
        } else {
          System.out.println(2);
          break;
        }
    }

  }
  static boolean calculate(char ch1, char ch2, char operate){

    if (operate=='|'){
      if (ch1=='T'||ch2=='T'){
        return true;
      }
      return false;
    }
    else{
      if (ch1=='T'&&ch2=='T'){
        return true;
      }
      return false;
    }
  }
}