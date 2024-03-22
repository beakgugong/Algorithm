import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    int N = Integer.valueOf(br.readLine());
    List<Cow> list = new ArrayList<>();
    int amountTime = 0;


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      Cow cow = new Cow(Integer.valueOf(stringTokenizer.nextToken()),Integer.valueOf(stringTokenizer.nextToken()));
      list.add(cow);
    }

    Collections.sort(list, new Comparator<Cow>() {
      @Override
      public int compare(Cow o1, Cow o2) {
        if (o1.arrive==o2.arrive){
          return o1.useTime- o2.useTime;
        }
        return o1.arrive-o2.arrive;
      }
    });
    for (int i=0; i<list.size(); i++){
      if (amountTime<list.get(i).arrive){
        amountTime = list.get(i).arrive+list.get(i).useTime;
      }
      else {
        amountTime += list.get(i).useTime;
      }
    }
    System.out.println(amountTime);
  }
  static class Cow{
    int arrive;
    int useTime;

    public Cow(int arrive, int useTime) {
      this.arrive = arrive;
      this.useTime = useTime;
    }
  }
}