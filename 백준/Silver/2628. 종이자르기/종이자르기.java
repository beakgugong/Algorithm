import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());
    int cutNum = Integer.parseInt(br.readLine());
    int[][] cutting = new int[2][cutNum];
    ArrayList<int[]> answer = new ArrayList<>();
    answer.add(new int[]{0,N,0,M});
    int max = Integer.MIN_VALUE;

    for (int i=0; i<cutNum; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      cutting[Integer.parseInt(stringTokenizer.nextToken())][i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    //0이면 가로
    //1이면 세로
    for (int i=0; i<cutNum; i++){
      ArrayList<int[]> addTmp = new ArrayList<>();
      ArrayList<int[]> removeTmp = new ArrayList<>();
      if (cutting[0][i]>0){
        for (int[] arr : answer){
          if (arr[2]<cutting[0][i]&&arr[3]>cutting[0][i]){
            addTmp.add(new int[]{arr[0],arr[1],arr[2],cutting[0][i]});
            addTmp.add(new int[]{arr[0],arr[1],cutting[0][i],arr[3]});
            removeTmp.add(arr);
          }
        }
      }else {
        for (int[] arr : answer){
          if (arr[0]<cutting[1][i]&&arr[1]>cutting[1][i]){
            addTmp.add(new int[]{arr[0],cutting[1][i],arr[2],arr[3]});
            addTmp.add(new int[]{cutting[1][i],arr[1],arr[2],arr[3]});
            removeTmp.add(arr);
          }
        }
      }
      for (int[] arr : addTmp){
        answer.add(arr);
      }
      for (int[] arr : removeTmp){
        answer.remove(arr);

      }
    }

    for (int[] arr : answer){
      max = Math.max(max,(arr[1]-arr[0])*(arr[3]-arr[2]));
    }
    System.out.println(max);
  }
}