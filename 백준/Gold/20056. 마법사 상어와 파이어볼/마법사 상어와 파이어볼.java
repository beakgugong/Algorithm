import java.io.*;
import java.util.*;

public class Main {
  static int[] dy = {-1,-1,0,1,1,1,0,-1};
  static int[] dx = {0,1,1,1,0,-1,-1,-1};
  static ArrayList<Fireball> arrayList;
  static ArrayList<Fireball>[][] map;
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    M = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    arrayList  = new ArrayList<>();
    map = new ArrayList[N][N];

    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        map[i][j] = new ArrayList<>();
      }
    }

    for (int i=0; i<M; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int y = Integer.valueOf(stringTokenizer.nextToken())-1;
      int x = Integer.valueOf(stringTokenizer.nextToken())-1;
      int m = Integer.valueOf(stringTokenizer.nextToken());
      int s = Integer.valueOf(stringTokenizer.nextToken());
      int d = Integer.valueOf(stringTokenizer.nextToken());

      Fireball fireball = new Fireball(y,x,m,s,d);
      arrayList.add(fireball);
    }

    for (int i=0; i<K; i++){
      move();
      addFireball();
    }

    int answer = 0;
    for (Fireball fireball : arrayList){
      answer += fireball.weight;
    }
    System.out.println(answer);
  }
  static void addFireball(){
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        if (map[i][j].size()>1){
          int sumW = 0, sumS = 0, hol = 0, jjak = 0;
          int size = map[i][j].size();
          for (Fireball fireball : map[i][j]){
            sumW+=fireball.weight;
            sumS+=fireball.speed;
            if (fireball.direction%2==0){
              jjak++;
            }
            else {
              hol++;
            }
            arrayList.remove(fireball);
          }
          sumW/=5;
          sumS/=size;

          if (sumW==0){
            map[i][j].clear();
            continue;
          }
          else {
            for (int k=0; k<4; k++) {
              if (jjak==size||hol==size) {
                arrayList.add(new Fireball(i, j, sumW, sumS,k*2));
              }
              else {
                arrayList.add(new Fireball(i, j, sumW, sumS,k*2+1));
              }
            }
          }
        }
        map[i][j].clear();
      }
    }
  }
  static void move(){

    for (int i=0; i<arrayList.size(); i++){
      int y = arrayList.get(i).y;
      int x = arrayList.get(i).x;
      int d = arrayList.get(i).direction;
      int s = arrayList.get(i).speed;
      int ny = (y+N+dy[d]*(s%N))%N;
      int nx = (x+N+dx[d]*(s%N))%N;

      arrayList.get(i).y = ny;
      arrayList.get(i).x = nx;

      map[ny][nx].add(arrayList.get(i));
    }

  }
  static class Fireball{
    int y;
    int x;
    int weight;
    int direction;
    int speed;

    public Fireball(int y, int x, int weight, int speed, int direction) {
      this.y = y;
      this.x = x;
      this.weight = weight;
      this.direction = direction;
      this.speed = speed;
    }
  }
}