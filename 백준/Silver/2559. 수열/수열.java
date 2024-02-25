import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    String[] strings = br.readLine().split(" ");
    int[] temperature = new int[strings.length];
    int n = Integer.valueOf(str[0]);
    int day = Integer.valueOf(str[1]);
    int max = Integer.MIN_VALUE;

    for(int i=0; i<temperature.length; i++){
      temperature[i] = Integer.valueOf(strings[i]);
    }
    if(day==1){
      Arrays.sort(temperature);
      System.out.println(temperature[temperature.length-1]);
      return;
    }
    for(int i=0; i<n-day+1; i++){
      int tmp = 0;
      for(int j=i; j<i+day; j++){
        tmp += temperature[j];
      }
      if(max<tmp){
        max = tmp;
      }
    }
    System.out.println(max);
  }
}