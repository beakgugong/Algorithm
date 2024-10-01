import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
  static int point = 0;
  static ArrayList<String> arrayList;
  static StringBuffer stringBuffer = new StringBuffer();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    arrayList = new ArrayList<>();

    for (int i=0; i<N; i++) {
      arrayList.add(br.readLine());
    }

    while (true){
      if (!arrayList.get(point).equals("KBS1")){
        one();
      }else{
        while (!arrayList.get(0).equals("KBS1")) {
          four();
        }
        break;
      }
    }

    while (true){
      if (!arrayList.get(point).equals("KBS2")){
        one();
      }else{
        while (!arrayList.get(1).equals("KBS2")) {
          four();
        }
        break;
      }
    }
    System.out.println(stringBuffer);



  }
  static void one(){
    point++;
    stringBuffer.append(1);
  }
  static void two(){
    point--;
    stringBuffer.append(2);
  }
  static void three(){
    String tmp = arrayList.get(point);
    arrayList.set(point, arrayList.get(point+1));
    arrayList.set(point+1, tmp);
    point++;
    stringBuffer.append(3);
  }
  static void four(){
    if (point==0){
      return;
    }
    String tmp = arrayList.get(point);
    arrayList.set(point, arrayList.get(point-1));
    arrayList.set(point-1, tmp);
    point--;
    stringBuffer.append(4);
  }
}