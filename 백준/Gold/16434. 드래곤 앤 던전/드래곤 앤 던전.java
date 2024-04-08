import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int hAttack = Integer.valueOf(stringTokenizer.nextToken());
    List<Room> rooms = new ArrayList<>();


    for (int i=0; i<N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int decide = Integer.valueOf(stringTokenizer.nextToken());
      int attack = Integer.valueOf(stringTokenizer.nextToken());
      int hp = Integer.valueOf(stringTokenizer.nextToken());

      if (decide==1){
        rooms.add(new Room(-attack,hp));
      }
      else {
        rooms.add(new Room(attack,hp));
      }
    }
    long low = 1;
    long high = Long.MAX_VALUE;

    while (low<=high) {
      long mid = (high+low)/2;
      long tmp = mid;
      long tmpAttack = hAttack;
      for (int i = 0; i < rooms.size(); i++) {
        if (rooms.get(i).attack < 0) {
          if (rooms.get(i).hp%tmpAttack==0){
            tmp += rooms.get(i).attack*(rooms.get(i).hp/tmpAttack-1);
          }
          else {
            tmp += rooms.get(i).attack*(rooms.get(i).hp/tmpAttack);
          }
          if (tmp<=0){
            tmp = -1;
            low = mid+1;
            break;
          }
        }
        else {
          tmpAttack+=rooms.get(i).attack;
          tmp+=rooms.get(i).hp;
          if (tmp>=mid){
            tmp = mid;
          }
        }
      }
      if (tmp>=0){
        high = mid-1;
      }
    }
    System.out.println(low);
  }
  static class Room{
    int attack;
    int hp;

    public Room(int attack, int hp) {
      this.attack = attack;
      this.hp = hp;
    }
  }
}
