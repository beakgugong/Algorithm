import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int[] s;

        while (k != 0) {
            s = new int[k];
            for (int i=0; i<k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(s);
            dfs(s,0,new ArrayList<>(),0);

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            System.out.println();
        }

    }
    static void dfs(int[] s, int count, ArrayList<Integer> arrayList, int index){
        if (count==6){
            arrayList.sort(Integer::compareTo);
            System.out.println(arrayList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i=index; i<s.length; i++){
            if (arrayList.indexOf(s[i])>=0){
                continue;
            }
            arrayList.add(s[i]);
            dfs(s, count+1, arrayList,i);
            arrayList.remove(arrayList.size()-1);
        }

    }
}