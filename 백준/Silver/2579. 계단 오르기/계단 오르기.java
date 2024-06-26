import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    int[] stair = new int[301];
    int[] answer = new int[301];

    for (int i=1; i<=N; i++){
      stair[i] = Integer.valueOf(br.readLine());
    }

    answer[1] = stair[1];
    answer[2] = stair[1]+stair[2];
    answer[3] = Math.max(stair[1]+stair[3],stair[2]+stair[3]);

    for (int i=4; i<=N; i++){
      answer[i] = Math.max(answer[i-2]+stair[i],answer[i-3]+stair[i-1]+stair[i]);
    }

    System.out.println(answer[N]);
  }
}