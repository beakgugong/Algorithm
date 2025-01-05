import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuffer stringBuffer = new StringBuffer();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            dfs(0,String.valueOf(arr[i]),i);
        }

        System.out.println(stringBuffer);
    }
    static void dfs(int count, String str,int index){
        if (count==M-1){
            stringBuffer.append(str+"\n");
            return;
        }

        for (int i = index; i < N; i++) {
            dfs(count+1, str+" "+arr[i], i);
        }
    }
}