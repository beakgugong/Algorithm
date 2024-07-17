import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    char[][] arr = new char[N][N];
    int[] heart = new int[2];
    int[] dx = {-1,1,0};
    int[] dy = {0,0,1};
    int[] leng = new int[5];

    for (int i=0; i<N; i++){
      arr[i] = br.readLine().toCharArray();
    }

    loop1:
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        if (arr[i][j]=='*'){
          heart[0] = i+2;
          heart[1] = j+1;
          break loop1;
        }
      }
    }

    int count = 0;
    for (int i=0; i<5; i++) {
      int len = 0;
      int startY = heart[0]-1;
      int startX = heart[1]-1;
      if (i==3){
        startY += (leng[2]+1);
        startX -= 1;
        count = 2;
        len = 1;
      } else if (i==4) {
        startY += (leng[2]+1);
        startX += 1;
        count = 2;
        len = 1;
      }

      while (startY>-1&&startX>-1&&startY<N&&startX<N&&arr[startY][startX] == '*') {
        startY += dy[count];
        startX += dx[count];
        len++;
      }
      leng[i] = len-1;
      count++;
    }
    System.out.println(heart[0]+" "+heart[1]);
    for (int i : leng){
      System.out.print(i+" ");
    }
  }
}