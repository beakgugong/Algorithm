import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int num;
  static StringBuffer stringBuffer = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(br.readLine());

    for (int i=0; i<N; i++){
      num = Integer.valueOf(br.readLine());

      dfs(1,1,"1", '1',1);
      stringBuffer.append("\n");
    }
    stringBuffer.deleteCharAt(stringBuffer.length()-1);
    System.out.println(stringBuffer);
  }
  static void dfs(int n, int sum, String str, char c, int before){
    if (n==num){
      if (sum==0){
        stringBuffer.append(str+"\n");
      }
      return;
    }

    for (int i=0; i<3; i++){
      if (i==0){
        if (c=='1'){
          dfs(n+1,sum-before+(before*10+n+1),str+ " "+(n+1),'1',(before * 10 + n + 1));
        }
        else if (c=='+') {
          dfs(n + 1, sum - before + (before * 10 + n + 1), str + " " + (n + 1),'+',(before * 10 + n + 1));
        }
        else if(c=='-') {
          dfs(n + 1, sum + before - (before * 10 + n + 1), str + " " + (n + 1),'-',(before * 10 + n + 1));
        }
      }
      else if (i==1){
        dfs(n+1,sum+(n+1),str+"+"+(n+1),'+',n+1);
      }
      else {
        dfs(n+1, sum-(n+1),str+"-"+(n+1),'-',n+1);
      }
    }
  }
}