import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer;
    StringBuffer stringBuffer = new StringBuffer();

    for (int i=0; i<T; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int num = Integer.valueOf(stringTokenizer.nextToken());
      int[] arr= new int[20];

      for (int j=0; j<20; j++){
        arr[j] = Integer.valueOf(stringTokenizer.nextToken());
      }

      int count  = insertSort(arr);
      stringBuffer.append(num+" "+count+"\n");
    }
    System.out.println(stringBuffer);
  }
  static int insertSort(int[] arr){
    int count = 0;
    for (int i=1; i<20; i++){
      for (int j=0; j<i; j++){
        if (arr[i]<arr[j]){
          int tmp = 0;
          tmp = arr[i];
          for (int k=i-1; k>j-1; k--){
            arr[k+1] = arr[k];
            count++;
          }
          arr[j] = tmp;
        }
      }
    }
    return count;
  }
}