import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int k = Integer.parseInt(stringTokenizer.nextToken());
    ArrayList<int[]> arrayList = new ArrayList<>();
    int[] dp = new int[100001];

    for (int i=0; i<n; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int weight = Integer.valueOf(stringTokenizer.nextToken());
      int value = Integer.valueOf(stringTokenizer.nextToken());

      arrayList.add(new int[]{weight,value});
    }

    Collections.sort(arrayList, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0]==o2[0]){
          return o1[1]-o1[1];
        }
        return o1[0]-o2[0];
      }
    });

    for (int i=0; i<n; i++){
      int weight = arrayList.get(i)[0];
      int value = arrayList.get(i)[1];

      for (int j=k; j-weight>=0; j--){
        dp[j] = Math.max(dp[j], dp[j-weight] + value);
      }
    }

    System.out.println(dp[k]);
  }
}