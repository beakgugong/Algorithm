import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int [] map = {
          0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
          10, 13, 16, 19, 25, 30, 35, 40, 0, //5->22
          20, 22, 24, 25, 30, 35, 40, 0,     //10->31
          30, 28, 27, 26, 25, 30, 35, 40, 0}; //15->39
  static boolean[] horseLocation = new boolean[48];
  static ArrayList<Horse> horses = new ArrayList<>();
  static int score = Integer.MIN_VALUE;
  static int[] dice;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    dice = new int[10];

    for (int i=0; i<10; i++){
      dice[i] = Integer.valueOf(stringTokenizer.nextToken());
    }

    for (int i=0; i<4; i++){
      Horse horse = new Horse(0);
      horses.add(horse);
    }
    dfs(0,0);
    System.out.println(score);
  }
  static void dfs(int count, int tmp){
    if (count==10){
      score = Math.max(score, tmp);
      return;
    }

    for (int i=0; i<horses.size(); i++){
      Horse horse = horses.get(i);
      int nLocation = horse.location+dice[count];
      int beforeLocation = horse.location;

      if (nLocation==5){
        nLocation = 22;
      } else if (nLocation==10){
        nLocation = 31;
      } else if (nLocation==15) {
        nLocation = 39;
      } else if (beforeLocation>-1&&beforeLocation<22&&nLocation>21) {
        nLocation = 21;
      } else if (beforeLocation>21&&beforeLocation<31&&nLocation>30){
        nLocation = 30;
      } else if (beforeLocation>30&&beforeLocation<39&&nLocation>38) {
        nLocation = 38;
      } else if (nLocation>47) {
        nLocation = 47;
      }

      if (horse.arrive||horseLocation[nLocation]){
        continue;
      }

      horseLocation[beforeLocation] = false;
      horse.allChangeFlag(false);
      horse.location = nLocation;
      if (nLocation!=47&&nLocation!=38&&nLocation!=30&&nLocation!=21) {
        horseLocation[horse.location] = true;
      }
      horse.check();
      horse.allChangeFlag(true);

      dfs(count+1, tmp+map[horse.location]);

      horseLocation[horse.location] = false;
      horse.allChangeFlag(false);
      horseLocation[beforeLocation] = true;
      horse.location = beforeLocation;
      horse.allChangeFlag(true);
      horse.check();

    }
  }
  static class Horse{
    int location;
    boolean arrive;
    public Horse(int location){
      this.location = location;
      this.arrive = false;
    }
    public void check(){
      if (location==47||location==21||location==30||location==38){
        arrive = true;
      }
      else arrive = false;
    }
    public void allChangeFlag(boolean flag){
      if (map[location]==25||map[location]==30||map[location]==35||map[location]==40) {
        if (map[location] == 10){
          horseLocation[5] = flag;
          horseLocation[22] = flag;
        } else if (map[location]==20){
          horseLocation[10] = flag;
          horseLocation[31] = flag;
        } else if (map[location] == 25) {
          horseLocation[26] = flag;
          horseLocation[34] = flag;
          horseLocation[43] = flag;
        } else if (map[location] == 30) {
          if (location==15||location==39){
            horseLocation[15] =flag;
            horseLocation[39] = flag;
            return;
          }
          horseLocation[27] = flag;
          horseLocation[35] = flag;
          horseLocation[44] = flag;
        }else if (map[location] == 35) {
          horseLocation[28] = flag;
          horseLocation[36] = flag;
          horseLocation[45] = flag;
        }else if (map[location] == 40) {
          horseLocation[20] = flag;
          horseLocation[29] = flag;
          horseLocation[37] = flag;
          horseLocation[46] = flag;
        }
      }
    }
  }
}