import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuffer stringBuffer = new StringBuffer(str);
    int zeroCount = 0;
    int oneCount = 0;
    for (int i=0; i<stringBuffer.length(); i++){
      if (stringBuffer.charAt(i)=='0'){
        zeroCount++;
      }
    }
    oneCount = (stringBuffer.length()-zeroCount)/2;
    zeroCount/=2;

    for (int i=0; i<oneCount; i++){
      for (int j=0; j<stringBuffer.length(); j++){
        if (stringBuffer.charAt(j)=='1'){
          stringBuffer.deleteCharAt(j);
          break;
        }
      }
    }
    for (int i=0; i<zeroCount; i++){
      for (int j=stringBuffer.length()-1; j>-1; j--){
        if (stringBuffer.charAt(j)=='0'){
          stringBuffer.deleteCharAt(j);
          break;
        }
      }
    }
    System.out.println(stringBuffer);

  }
}