import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Egg> eggs;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.valueOf(br.readLine());
      eggs = new ArrayList<>();

      StringTokenizer st;

      for (int i=0; i<N; i++) {
          st = new StringTokenizer(br.readLine());
          int innerPower = Integer.valueOf(st.nextToken());
          int weight = Integer.valueOf(st.nextToken());

          eggs.add(new Egg(weight, innerPower));
      }

      dfs(0,0);
      System.out.println(max);
    }
    static void dfs(int count, int broken) {
        if (count == N) {
            max = Math.max(max, broken);
            return;
        }
        if (eggs.get(count).innerPower <= 0) {
            dfs(count+1, broken);
            return;
        }
        for (int i = 0; i < eggs.size(); i++) {
            if (eggs.get(i).innerPower <= 0||i==count) {
                continue;
            }

            eggs.get(i).innerPower -= eggs.get(count).weight;
            eggs.get(count).innerPower -= eggs.get(i).weight;

            if (eggs.get(count).innerPower <= 0&&eggs.get(i).innerPower <= 0) {
                dfs(count + 1, broken+2);
            } else if (eggs.get(count).innerPower <= 0||eggs.get(i).innerPower <= 0) {
                dfs(count + 1, broken+1);
            }else dfs(count + 1, broken);

            eggs.get(i).innerPower += eggs.get(count).weight;
            eggs.get(count).innerPower += eggs.get(i).weight;

        }
        max = Math.max(max, broken);
    }
  static class Egg{
        int weight;
        int innerPower;

        public Egg(int weight, int innerPower) {
            this.weight = weight;
            this.innerPower = innerPower;
        }
  }
}