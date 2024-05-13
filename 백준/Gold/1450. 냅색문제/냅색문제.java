import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int C;
  static int[] arr1;
  static int[] arr2;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    C = Integer.valueOf(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(br.readLine());
    arr1 = new int[N/2];
    arr2 = new int[N-arr1.length];

    for (int i=0; i<N; i++){
      if (i<N/2){
        arr1[i] = Integer.valueOf(stringTokenizer.nextToken());
      }
      else
        arr2[i-N/2] = Integer.valueOf(stringTokenizer.nextToken());
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    ArrayList<Integer> sum1 = new ArrayList<>();
    ArrayList<Integer> sum2 = new ArrayList<>();
    dfs(0,0,arr1,sum1);
    dfs(0,0,arr2,sum2);
    Collections.sort(sum2);

    long answer = 0;
    for (int i=0; i<sum1.size(); i++){
      int search = C-sum1.get(i);
      int high = sum2.size()-1;
      int low = 0;
      int tmp  = -1;
      while (low<=high){
        int mid = (high+low)/2;

        if (sum2.get(mid)>search){
          high = mid-1;
        }
        else {
          tmp = mid;
          low = mid+1;
        }
      }
      answer+=tmp+1;
    }
    System.out.println(answer);
  }
  static void dfs(int idx, int sum, int[] arr, ArrayList<Integer> answer){
    if (sum>C){
      return;
    }
    if (idx==arr.length){
      answer.add(sum);
      return;
    }
    dfs(idx+1, sum+arr[idx], arr, answer);
    dfs(idx+1, sum,arr, answer);
  }
}
