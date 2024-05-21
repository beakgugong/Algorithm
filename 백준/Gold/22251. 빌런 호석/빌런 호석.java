import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int K;
  static int P;
  static int X;
  static int[][] number = {{1, 1, 1, 1, 1, 1, 0},{0, 0, 0, 0, 1, 1, 0},
          {1, 0, 1, 1, 0, 1, 1},{1, 0, 0, 1, 1, 1, 1},{0, 1, 0, 0, 1, 1, 1},
          {1, 1, 0, 1, 1, 0, 1},{1, 1, 1, 1, 1, 0, 1},{1, 0, 0, 0, 1, 1, 0},
          {1, 1, 1, 1, 1, 1, 1},{1, 1, 0, 1, 1, 1, 1}};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    K = Integer.valueOf(stringTokenizer.nextToken());
    P = Integer.valueOf(stringTokenizer.nextToken());
    X = Integer.valueOf(stringTokenizer.nextToken());

    int[] arr;
    arr = changNum(X);
    int answer = calculate(arr);
    System.out.println(answer);


  }

  private static int calculate(int[] arr) {
    int count = 0;
    for (int i=1; i<=N; i++){
      if(i==X){
        continue;
      }
      if (revers(i,arr)){
        count++;
      }
    }
    return count;
  }

  private static boolean revers(int i, int[] arr) {
    int[] tmp = changNum(i);
    int count = 0;

    for (int j=0; j<K; j++){
      for (int k=0; k<7; k++){
        if (number[arr[j]][k] != number[tmp[j]][k]){
          count++;
          if (count>P){
            return false;
          }
        }
      }
    }
    return true;
  }

  public static int[] changNum(int i){
    int[] arr = new int[K];

    for (int j=K-1; j>=0; j--){
      arr[j] = i%10;
      i/=10;
    }
    return arr;
  }
}
