import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Passenger> arrayList;
  static int[][] map;
  static int N;
  static int M;
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    int fuel = Integer.valueOf(stringTokenizer.nextToken());
    map = new int[N][N];
    arrayList = new ArrayList<>();
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[2]==o2[2]){
          if (o1[0]==o2[0]){
            return o1[1]-o2[1];
          }
          return o1[0]-o2[0];
        }
        return o1[2]-o2[2];
      }
    });


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++){
        map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
      }
    }

    stringTokenizer = new StringTokenizer(br.readLine());
    Taxi taxi = new Taxi(Integer.valueOf(stringTokenizer.nextToken())-1,Integer.valueOf(stringTokenizer.nextToken())-1,fuel);

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int startY = Integer.valueOf(stringTokenizer.nextToken())-1;
      int startX = Integer.valueOf(stringTokenizer.nextToken())-1;
      int endY = Integer.valueOf(stringTokenizer.nextToken())-1;
      int endX = Integer.valueOf(stringTokenizer.nextToken())-1;

      arrayList.add(new Passenger(startY,startX,endY,endX,-1));
    }
    //거리 미리 계산하기
    calculate();

    //승객을 모두 태우면 종료
    while (!arrayList.isEmpty()) {
      //현재 택시 위치에서 가장 가까운 승객찾기
      queue.add(new int[]{taxi.y, taxi.x, 0});
      boolean[][] visit = new boolean[N][N];
      visit[taxi.y][taxi.x] = true;

      loop1:
      while (true) {
        int y = queue.peek()[0];
        int x = queue.peek()[1];
        int distance = queue.peek()[2];
        //승객 찾으면 연료 계산하기
        for (int j = 0; j < arrayList.size(); j++) {
          if (arrayList.get(j).startY == y && arrayList.get(j).startX == x) {
            taxi.y = arrayList.get(j).endY;
            taxi.x = arrayList.get(j).endX;
            taxi.fuel-= distance;
            taxi.fuel -= arrayList.get(j).distance;
            //연료가 동났으면 종료
            if (taxi.fuel<0){
              System.out.println(-1);
              return;
            }
            taxi.fuel += arrayList.get(j).distance*2;
            queue.clear();
            arrayList.remove(j);
            break loop1;
          }
        }

        queue.poll();
        for (int i = 0; i < 4; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];

          if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || map[ny][nx] == 1 || visit[ny][nx]) {
            continue;
          }

          visit[ny][nx] = true;
          queue.add(new int[]{ny, nx, distance+1});
        }
        //승객이 있지만 접근 불가능할때
        if (queue.isEmpty()){
          System.out.println(-1);
          return;
        }
      }
    }
    System.out.println(taxi.fuel);


  }
  //승객 출발지에서 목적지까지 거리 계산
  static void calculate(){
    int[][] copyMap = new int[N][N];
    Queue<int[]> queue = new LinkedList<>();
    for (int i=0; i<N; i++){
      copyMap[i] = map[i].clone();
    }

    for (int i=0; i<arrayList.size(); i++){
      boolean[][] visit = new boolean[N][N];
      int endX = arrayList.get(i).endX;
      int endY = arrayList.get(i).endY;
      int startX = arrayList.get(i).startX;
      int startY = arrayList.get(i).startY;
      visit[startY][startX] = true;

      queue.add(new int[]{startY,startX,0});

      Loop1 :
      while (!queue.isEmpty()){
        int y = queue.peek()[0];
        int x = queue.peek()[1];
        int distance = queue.peek()[2];


        if (x==endX&&y==endY){
          arrayList.get(i).distance = distance;
          queue.clear();
          break Loop1;
        }

        queue.poll();

        for (int j=0; j<4; j++){
          int nx = x+dx[j];
          int ny = y+dy[j];

          if (nx<0||ny<0||nx>N-1||ny>N-1||map[ny][nx]==1||visit[ny][nx]){
            continue;
          }
          visit[ny][nx] = true;
          queue.add(new int[]{ny,nx,distance+1});
        }
      }
      if (arrayList.get(i).distance==-1){
        System.out.println(-1);
        System.exit(0);
      }
    }
  }
  //승객
  static class Passenger{
    int startY;
    int startX;
    int endY;
    int endX;
    int distance;

    public Passenger(int startY, int startX, int endY, int endX, int distance) {
      this.startY = startY;
      this.startX = startX;
      this.endY = endY;
      this.endX = endX;
      this.distance = distance;
    }
  }
  static class Taxi {
    int x;
    int y;
    int fuel;

    public Taxi(int y, int x, int fuel) {
      this.x = x;
      this.y = y;
      this.fuel = fuel;
    }
  }
}