import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
         dfs(0,String.valueOf(i));
        }
        System.out.println(stringBuffer);
    }
    static void dfs(int count, String str){
        if (count==M-1){
            stringBuffer.append(str+"\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            dfs(count+1, str+" "+i);
        }
    }
}