import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] fib = new int[N+1];
    fib[0] = 0; fib[1] = 1; fib[2] = 1;
    ArrayList<Integer> serim = new ArrayList<>();
    ArrayList<Integer> sungju = new ArrayList<>();

    for (int i=3; i<fib.length; i++){
      fib[i] = fib[i-1]+fib[i-2];
    }

    if ((N-2)%3==0){
      serim.add(1);
      sungju.add(2);
      for (int i=3; i<=N; i+=3){
        serim.add(i);
        serim.add(i+1);
        sungju.add(i+2);
      }
    }
    else if (N%3==0){
      for (int i=1; i<=N; i+=3){
        serim.add(i);
        serim.add(i+1);
        sungju.add(i+2);
      }
    }
    else {
      for (int i=1; i<N; i+=3){
        serim.add(i);
        serim.add(i+1);
        sungju.add(i+2);
      }
    }

    System.out.println(serim.size());
    StringBuffer stringBuffer1 = new StringBuffer();
    for (int i=0; i<serim.size(); i++){
      stringBuffer1.append(serim.get(i)+" ");
    }
    System.out.println(stringBuffer1);

    System.out.println(sungju.size());
    StringBuffer stringBuffer2 = new StringBuffer();
    for (int i=0; i<sungju.size(); i++){
      stringBuffer2.append(sungju.get(i)+" ");
    }
    System.out.println(stringBuffer2);
  }
}