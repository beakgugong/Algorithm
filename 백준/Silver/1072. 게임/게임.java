import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    long X = Integer.valueOf(stringTokenizer.nextToken());
    long Y = Integer.valueOf(stringTokenizer.nextToken());

    long low = 1;
    long high = 1000000000;
    long winPer = (Y*100)/X;
    long answer = Integer.MAX_VALUE;

    while (low<=high){
      long mid = (low+high)/2;
      long tmpX = X+mid;
      long tmpY = Y+mid;
      
      long tmpWinPer = (tmpY*100)/tmpX;
      if (tmpWinPer!=winPer){
        answer = Math.min(mid,answer);
        high = mid-1;
      }
      else {
        low = mid + 1;
      }
    }

    if (answer==Integer.MAX_VALUE){
      answer = -1;
    }
    System.out.println(answer);
  }
}
