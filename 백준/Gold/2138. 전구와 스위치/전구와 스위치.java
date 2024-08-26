import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(br.readLine());
    String first = br.readLine();
    String second = br.readLine();
    boolean[] tmp1 = new boolean[n];
    boolean[] tmp2 = new boolean[n];
    boolean[] goal = new boolean[n];
    int count1 = 0;
    int count2 = 0;
    int min = Integer.MAX_VALUE;

    boolChange(tmp1,first);
    boolChange(tmp2,first);
    boolChange(goal,second);

    oneToZero(tmp1,0);
    oneToZero(tmp1,1);
    count1++;

    if (Arrays.equals(tmp2,goal)){
      System.out.println(0);
      return;
    }

    for (int i=0; i<n-2; i++){

      if (goal[i]!=tmp1[i]){
        oneToZero(tmp1,i);
        oneToZero(tmp1,i+1);
        oneToZero(tmp1,i+2);
        count1++;
      }

      if (goal[i]!=tmp2[i]){
        oneToZero(tmp2,i);
        oneToZero(tmp2,i+1);
        oneToZero(tmp2,i+2);
        count2++;
      }

      if (Arrays.equals(tmp1,goal)){
        min = Math.min(min,count1);
      }
      if (Arrays.equals(tmp2,goal)){
        min = Math.min(min,count2);
      }
    }

    if (goal[n-2]!=tmp1[n-2]){
      oneToZero(tmp1,n-2);
      oneToZero(tmp1,n-1);
      count1++;
    }
    if (goal[n-2]!=tmp2[n-2]){
      oneToZero(tmp2,n-2);
      oneToZero(tmp2,n-1);
      count2++;
    }

    if (Arrays.equals(tmp1,goal)){
      min = Math.min(min,count1);
    }
    if (Arrays.equals(tmp2,goal)){
      min = Math.min(min,count2);
    }

    System.out.println(min==Integer.MAX_VALUE?-1:min);
  }
  static void oneToZero(boolean[] arr, int i){
    arr[i]= !arr[i];
  }
  static void boolChange(boolean[] arr, String str){
    for (int i=0; i<str.length(); i++){
      if (str.charAt(i)=='1'){
        arr[i] = true;
      }
      else arr[i] = false;
    }
  }
}