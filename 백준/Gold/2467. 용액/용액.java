import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] fluid = new int[N];
    int[] record = new int[N];
    int min = Integer.MAX_VALUE;
    int answer = 0;
    int one = 0;
    int two = 0;

    for (int i=0; i<N; i++){
      fluid[i] = Integer.valueOf(stringTokenizer.nextToken());
    }
    if (N==2){
      System.out.println(fluid[0]+" "+fluid[1]);
      return;
    }

    for (int i=0; i<N-1; i++){
      one = fluid[i];

      int left = i+1;
      int right = N-1;
      int mid = (left+right)/2;
      two = fluid[mid];

      while (left<right){
        mid = (left+right)/2;
        two = fluid[mid];

        if (two+one>0){
          right = mid-1;
        }
        else if (two + one < 0) {
          left = mid + 1;
        } else {
          System.out.println(one<two?one+" "+two:two+" "+one);
          return;
        }
      }

      if (left==right){
        if (Math.abs(one+two)>Math.abs(one+fluid[(left+right)/2])){
          two = fluid[(left+right)/2];
        }
      }

      record[i] = two;
      if (min>Math.abs(one+two)){
        min=Math.abs(one+two);
        answer = i;
      }
    }
    System.out.println(fluid[answer]+" "+record[answer]);
  }
}