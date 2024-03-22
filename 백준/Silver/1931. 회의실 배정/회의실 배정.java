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
    List<Conference> list = new ArrayList<>();
    int amount = 1;


    for (int i=0; i<N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      Conference conference = new Conference(Integer.valueOf(stringTokenizer.nextToken()),Integer.valueOf(stringTokenizer.nextToken()));
      list.add(conference);
    }

    Collections.sort(list, new Comparator<Conference>() {
      @Override
      public int compare(Conference o1, Conference o2) {
        if (o1.end==o2.end){
          return o1.start- o2.start;
        }
        return o1.end-o2.end;
      }
    });

    int currentTime = list.get(0).end;

    for (int i=1; i<list.size(); i++){
      if(list.get(i).start>=currentTime){
        amount++;
        currentTime = list.get(i).end;
      }

    }
    System.out.println(amount);

  }
  static class Conference{
    int start;
    int end;

    public Conference(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}