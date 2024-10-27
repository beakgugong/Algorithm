import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];


    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      }
    });

    PriorityQueue<ClassRoom> classRooms = new PriorityQueue<>(Comparator.comparing(ClassRoom::getNum));
    classRooms.add(new ClassRoom(arr[0][1]));

    for (int i = 1; i < N; i++) {
      int a = arr[i][0];
      int b = arr[i][1];

      if (classRooms.peek().getNum() <= a) {
        classRooms.poll();
      }
      classRooms.add(new ClassRoom(b));
    }

    System.out.println(classRooms.size());
  }
  static class ClassRoom{
    int num;

    public ClassRoom(int num){
      this.num = num;
    }
    public int getNum(){
      return num;
    }

  }
}