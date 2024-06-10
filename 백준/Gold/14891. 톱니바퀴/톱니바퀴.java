import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<Wheel> arrayList;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arrayList = new ArrayList<>();

    for (int i=0; i<4; i++){
      String str = br.readLine();
      int[] state = new int[8];
      Wheel wheel = new Wheel();
      wheel.num = i;

      for (int j=0; j<8; j++){
        state[j] = str.charAt(j)-48;
      }
      wheel.state = state;
      arrayList.add(wheel);
    }

    StringTokenizer stringTokenizer;
    int k = Integer.valueOf(br.readLine());
    for (int i=0; i<k; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int num = Integer.valueOf(stringTokenizer.nextToken())-1;
      int direction = Integer.valueOf(stringTokenizer.nextToken());
      int[] move = new int[4];

      move[num] = direction;

      switch (num){
        case 0:
          if (arrayList.get(0).state[2]!=arrayList.get(1).state[6]){
            move[1] = -move[0];
            if (arrayList.get(1).state[2]!=arrayList.get(2).state[6]){
              move[2] = -move[1];
              if (arrayList.get(2).state[2]!=arrayList.get(3).state[6]){
                move[3] = -move[2];
              }
            }
          }
          break;

        case 1:
          if (arrayList.get(1).state[6]!=arrayList.get(0).state[2]){
            move[0] = -move[1];
          }
          if (arrayList.get(1).state[2]!=arrayList.get(2).state[6]){
            move[2] = -move[1];
            if (arrayList.get(2).state[2]!=arrayList.get(3).state[6]){
              move[3] = -move[2];
            }
          }
          break;

        case 2:
          if (arrayList.get(2).state[2]!=arrayList.get(3).state[6]){
            move[3] = -move[2];
          }
          if (arrayList.get(2).state[6]!=arrayList.get(1).state[2]){
            move[1] = -move[2];
            if (arrayList.get(1).state[6]!=arrayList.get(0).state[2]){
              move[0] = -move[1];
            }
          }
          break;

        case 3:
          if (arrayList.get(3).state[6]!=arrayList.get(2).state[2]){
            move[2] = -move[3];
            if (arrayList.get(2).state[6]!=arrayList.get(1).state[2]){
              move[1] = -move[2];
              if (arrayList.get(1).state[6]!=arrayList.get(0).state[2]){
                move[0] = -move[1];
              }
            }
            }
            break;
        }

      for (int j=0; j<4; j++){
        move(j,move[j]);
      }
    }

    int answer = 0;
    int multiplication = 1;
    for (int i=0; i<4; i++){
      if (arrayList.get(i).state[0]==1){
        answer+=multiplication;
      }
      multiplication*=2;
    }

    System.out.println(answer);
  }
  static void move(int num, int direction){
    if (direction==1) {
      int tmp = arrayList.get(num).state[7];
      for (int j = 7; j > 0; j--) {
        arrayList.get(num).state[j] = arrayList.get(num).state[(j+7)%8];
      }
      arrayList.get(num).state[0] = tmp;
    }
    else if (direction==-1){
      int tmp = arrayList.get(num).state[0];
      for (int j = 0; j < 7; j++) {
        arrayList.get(num).state[j] = arrayList.get(num).state[(j+9)%8];
      }
      arrayList.get(num).state[7] = tmp;
    }
  }
  static class Wheel{
    int num;
    int[] state;
  }
}