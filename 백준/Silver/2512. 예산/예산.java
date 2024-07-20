import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int[] request = new int[N];
    int amountMoney = Integer.valueOf(br.readLine());
    int amount = 0;
    int answer = 0;

    for (int i=0; i<N; i++){
      request[i] = Integer.valueOf(stringTokenizer.nextToken());
      amount+=request[i];
    }
    Arrays.sort(request);
    if (amount<=amountMoney){
      System.out.println(request[N-1]);
      return;
    }

    int left = 0;
    int right = request[N-1];

    while (left<=right){
      int mid = (left+right)/2;

      int tmpAmount = amountMoney;

      for (int i=0; i<N; i++){
        if (request[i]<=mid){
          tmpAmount-=request[i];
        }
        else tmpAmount-=mid;
      }


      if (tmpAmount>=0){
        left = mid+1;
      }
      else {
        right = mid-1;
      }
      answer = right;
    }
    System.out.println(answer);
  }
}