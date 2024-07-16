import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(stringTokenizer.nextToken());
    int K = Integer.valueOf(stringTokenizer.nextToken());
    ArrayList<Country> arrayList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int num = Integer.valueOf(stringTokenizer.nextToken());
      int gold = Integer.valueOf(stringTokenizer.nextToken());
      int silver = Integer.valueOf(stringTokenizer.nextToken());
      int copper = Integer.valueOf(stringTokenizer.nextToken());
      Country country = new Country(num, gold, silver, copper);
      arrayList.add(country);
    }

    Collections.sort(arrayList, new Comparator<Country>() {
      @Override
      public int compare(Country o1, Country o2) {
        if (o2.gold == o1.gold) {
          if (o2.silver == o1.silver) {
            if (o2.copper == o1.copper){
              o1.tie = true;
            }
            return o2.copper - o1.copper;
          }
          return o2.silver - o1.silver;
        }
        return o2.gold - o1.gold;
      }
    });

    int rank = 1;
    int count = 0;

    for (Country c :arrayList){
      if (c.tie){
        c.rank = (rank-1);
        count++;
        continue;
      }
      if (count>0){
        rank+=count;
        c.rank = rank;
        count=0;
        rank++;
        continue;
      }
        c.rank = rank;
        rank++;
    }
    System.out.println(arrayList.get(K-1).rank);
  }
  static class Country{
    int num;
    int gold;
    int silver;
    int copper;
    int rank;
    boolean tie;

    public Country(int num, int gold, int silver, int copper) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.copper = copper;
    }

    }
  }