import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.sound.midi.Soundbank;

public class Main {
  static boolean[] switchs;
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    switchs = new boolean[N+1];
    stringTokenizer = new StringTokenizer(br.readLine());

    for (int i=1; i<N+1; i++){
      int onOff = Integer.valueOf(stringTokenizer.nextToken());
      if (onOff==1){
        switchs[i] = true;
      }
    }

    int p = Integer.valueOf(br.readLine());

    for (int i=0; i<p; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      int sex = Integer.valueOf(stringTokenizer.nextToken());
      int num = Integer.valueOf(stringTokenizer.nextToken());
      if (sex==1){
        male(num);
      }
      else female(num);
    }
    
    int count = 0;
    for (int i=1; i<N+1; i++){
      if (switchs[i]){
        System.out.print(1+" ");
      }
      else System.out.print(0+" ");
      count++;
      if (count%20==0){
        System.out.println();
      }
    }

  }
  static void male(int num){
    for (int i=num; i<N+1; i+=num){
      switchs[i]= (!switchs[i]);
    }
  }
  static void female(int num){
    int left = num-1;
    int right = num+1;
    switchs[num] = !switchs[num];
    while (true){
      if (left<1||right>N){
        break;
      }
      if (switchs[left]==switchs[right]){
        switchs[left] = !switchs[left];
        switchs[right] = !switchs[right];
      }
      else break;
      left--;
      right++;
    }
  }
}