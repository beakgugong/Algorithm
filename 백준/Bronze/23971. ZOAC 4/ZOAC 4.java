import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int H = Integer.valueOf(stringTokenizer.nextToken());
    int W = Integer.valueOf(stringTokenizer.nextToken());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int M = Integer.valueOf(stringTokenizer.nextToken());
    int f = (H-1)/(N+1)+1;
    int s = (W-1)/(M+1)+1;

    System.out.println(f*s);
  }
}