import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int M;
  static int[][] city;
  static ArrayList<int[]> chicken;
  static ArrayList<int[]> person;
  static boolean[] visited;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    city = new int[N][N];
    chicken = new ArrayList<>();
    person = new ArrayList<>();

    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for(int j=0; j<N; j++){
        city[i][j] = Integer.valueOf(stringTokenizer.nextToken());
        if (city[i][j] == 2){
          chicken.add(new int[]{i,j});
        }
        else if (city[i][j]==1){
          person.add(new int[]{i,j});
        }
      }
    }
    visited = new boolean[chicken.size()];
    answer = Integer.MAX_VALUE;
    find(0,0);
    System.out.println(answer);
  }

  static void find(int start, int count){

    if(count == M){
      int amount = 0;
      for (int i=0; i< person.size(); i++){
        int tmp = Integer.MAX_VALUE;

        for (int j=0; j< chicken.size(); j++){
          if(visited[j]) {
            int nx = Math.abs(person.get(i)[1] - chicken.get(j)[1]);
            int ny = Math.abs(person.get(i)[0] - chicken.get(j)[0]);

            if (tmp > (nx + ny)) {
              tmp = nx + ny;

            }
          }
        }
        amount+=tmp;
      }
      answer = Math.min(answer,amount);
      return;
    }

    for (int i=start; i<chicken.size(); i++){
      visited[i] = true;
      find(i+1, count+1);
      visited[i] = false;
    }
  }
}