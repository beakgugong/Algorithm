import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String str = br.readLine();
  String[] strs = str.split(" ");
  int[] fee = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
  int[][] time = new int[3][2];
  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;
  int count = 0;
  int answer = 0;

  for(int i=0; i<3; i++){
    StringTokenizer st = new StringTokenizer(br.readLine());
    time[i][0] = Integer.parseInt(st.nextToken());
    time[i][1] = Integer.parseInt(st.nextToken());
  }

  for (int[] piece : time){
    if(min>piece[0]){
      min = piece[0];
    }
    if (max<piece[1]){
      max = piece[1];
    }
  }

  for(int i=min; i<=max; i++){
    for (int j=0; j<3; j++){
      if (i>=time[j][0]&&i<time[j][1]){
        count++;
      }
    }
    switch (count){
      case 1 : answer += fee[0];
      break;
      case 2 : answer += fee[1]*2;
      break;
      case 3 : answer += fee[2]*3;
    }
    count = 0;
  }
  System.out.println(answer);
  br.close();

  }

}