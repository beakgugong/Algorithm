import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int answer = 0;
    String str = br.readLine();
    int[] arr = new int[26];
    int[] tmp;

    for (int i=0; i<str.length(); i++){
      arr[str.charAt(i)-65]++;
    }

    for (int i=0; i<N-1; i++){
      String tmpStr = br.readLine();
      int count = 0;
      int oneCount = 0;
      int tmpCount = 0;
      tmp = new int[26];
      for (int j=0; j<tmpStr.length(); j++) {
        tmp[tmpStr.charAt(j)-65]++;
      }

      for (int j=0; j<26; j++){
        int num = Math.abs(tmp[j]-arr[j]);
        if (tmp[j]>arr[j]&&num==1){
          tmpCount++;
        } else if (tmp[j]<arr[j]&&num==1){
          oneCount++;
        }
        else count+=num;
      }

      if (count>1||tmpCount>1||oneCount>1){
        continue;
      }
      answer++;
    }

    System.out.println(answer);
  }
}