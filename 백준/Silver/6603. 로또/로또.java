import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];

            if (n==0)break;

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            printFunc(numbers);
            st = new StringTokenizer(br.readLine());
        }
    }

    static void printFunc(int[] numbers) {
        Arrays.sort(numbers);
        dfs(0, 0, "", numbers);
        System.out.println(stringBuffer);
        stringBuffer.setLength(0);

    }
    static void dfs(int index, int count, String str, int[] numbers){
        if (count==6){
            stringBuffer.append(str+"\n");
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            dfs(i+1, count+1, str+String.valueOf(numbers[i]+" "), numbers);
        }
    }
}