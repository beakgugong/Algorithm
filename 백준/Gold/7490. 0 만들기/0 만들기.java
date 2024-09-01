import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
  static int N;
  static int tmp;
  static ArrayList<String> stringArrayList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.valueOf(br.readLine());
    stringArrayList = new ArrayList<>();

    for (int i=0; i<N; i++){
      tmp = Integer.valueOf(br.readLine());

      dfs(1,1, '1',1,"1");
      Collections.sort(stringArrayList);

      for (String str : stringArrayList){
        System.out.println(str);
      }
      System.out.println();
      stringArrayList.clear();
    }

  }

  static void dfs(int current, int sum, char c, int before, String str){
    if (current==tmp){
      if (sum==0){
        stringArrayList.add(str);
      }
      return;
    }

    for (int i=0; i<3; i++) {
      int next = current+1;
      int blankNum = before*10;
      
      if (i == 0) {
        switch (c) {
          case '+':
            dfs(next, sum-before+(blankNum+next), '+',blankNum+next, str+" "+next);
            break;
          case '-':
            dfs(next, sum+before-(blankNum+next), '-',blankNum+next, str+" "+next);
            break;
          case '1':
            dfs(next, sum-before+(blankNum+next), '1',blankNum+next, str+" "+next);
            break;

        }
      } else if (i==1) {
        dfs(next,sum+next,'+',next,str+"+"+next);
      }
      else dfs(next,sum-next,'-',next,str+"-"+next);
    }
  }
}