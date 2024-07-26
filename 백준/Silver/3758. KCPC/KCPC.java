import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static  void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(br.readLine());

    for (int i=0; i<T; i++){
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

      int n = Integer.valueOf(stringTokenizer.nextToken());
      int k = Integer.valueOf(stringTokenizer.nextToken());
      int d = Integer.valueOf(stringTokenizer.nextToken());
      int log = Integer.valueOf(stringTokenizer.nextToken());
      ArrayList<Team> arrayList = new ArrayList<>();
      HashMap<Integer, Team> hashMap = new HashMap<>();

      for (int j=0; j<log; j++){
        stringTokenizer = new StringTokenizer(br.readLine());

        int teamNum = Integer.valueOf(stringTokenizer.nextToken());
        int problemNum = Integer.valueOf(stringTokenizer.nextToken());
        int score = Integer.valueOf(stringTokenizer.nextToken());
        if (hashMap.containsKey(teamNum)){
          Team team = hashMap.get(teamNum);
          team.submitCount++;
          if (team.score[problemNum]<score){
            team.sumScore-=team.score[problemNum];
            team.sumScore+=score;
            team.score[problemNum] = score;
          }
          team.lastLog = j;
          continue;
        }

        Team team = new Team();
        team.num = teamNum;
        team.submitCount = 1;
        team.lastLog = j;
        team.sumScore = score;
        team.score = new int[k+1];
        team.score[problemNum] = score;
        arrayList.add(team);
        hashMap.put(teamNum, team);
      }
      int answer = rank(d, arrayList,hashMap);
      System.out.println(answer);
    }
  }
  static int rank(int d, ArrayList<Team> teams, HashMap<Integer,Team> hashMap){
    Collections.sort(teams, new Comparator<Team>() {
      @Override
      public int compare(Team o1, Team o2) {
        if (o2.sumScore==o1.sumScore){
          if (o1.submitCount==o2.submitCount){
            return o1.lastLog-o2.lastLog;
          }
          return o1.submitCount-o2.submitCount;
        }
        return o2.sumScore- o1.sumScore;
      }
    });

    return teams.indexOf(hashMap.get(d))+1;

  }
  static class Team{
    int num;
    int submitCount;
    int sumScore;
    int[] score;
    int lastLog;


  }
}