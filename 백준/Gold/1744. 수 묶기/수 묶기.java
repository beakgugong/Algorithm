import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int[] num;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    num = new int[N];
    ArrayList<Integer> plus = new ArrayList<>();
    ArrayList<Integer> minus = new ArrayList<>();

    long sum = 0;

    for (int i=0; i<N; i++){
      num[i] = Integer.valueOf(br.readLine());
      if (num[i]>=0) plus.add(num[i]);
      if (num[i]<0) minus.add(num[i]);
    }

    Collections.sort(plus);
    Collections.sort(minus, Collections.reverseOrder());

    if (plus.size()>0&&minus.size()%2!=0&&plus.get(0)==0){
      minus.remove(0);
      plus.remove(0);
    }

    sum+=calculate(plus);
    sum+=calculate(minus);

    System.out.println(sum);


  }

  static long calculate(ArrayList<Integer> list){
    int pointOne = list.size()-1;
    int pointTwo = list.size()-2;
    long sum = 0;

    while (pointTwo>-1 && list.get(pointOne) * list.get(pointTwo) > list.get(pointOne) + list.get(pointTwo)) {
      sum += (list.get(pointOne) * list.get(pointTwo));
      pointOne = pointTwo - 1;
      pointTwo-=2;
    }

    while (pointOne > -1) {
      sum += list.get(pointOne);
      pointOne--;
    }
   return sum;
  }
}