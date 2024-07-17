import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int score = Integer.valueOf(stringTokenizer.nextToken());
    int P = Integer.valueOf(stringTokenizer.nextToken());
    try {
      stringTokenizer = new StringTokenizer(br.readLine());
    }catch (NullPointerException e){

    }

    int rank = 1;
    int tie = 0;
    for (int i=0; i<N; i++){
      int original = Integer.valueOf(stringTokenizer.nextToken());
      if (original>score){
        rank++;
      } else if (original==score) {
        tie++;
      }
      else break;
    }

    if (rank+tie>P){
      System.out.println(-1);
    }
    else {
      System.out.println(rank);
    }

  }
}