import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0,-1,0,1};
  static int[] dy = {-1,0,1,0};
  static Student[] students;
  static int[][] arr;
  static boolean[][] visit;
  static int N;
  static int answer = 0;
   static Map<Integer,Integer> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    N = Integer.valueOf(stringTokenizer.nextToken());
    students = new Student[N*N];
    arr = new int[N][N];
    visit = new boolean[N][N];

    for (int i=0; i<N*N; i++){
      stringTokenizer = new StringTokenizer(br.readLine());
      Student student = new Student();
      student.num = Integer.valueOf(stringTokenizer.nextToken());
      map.put(student.num,i);
      student.favoriteStu = new ArrayList<>();

      for (int j=0; j<4; j++){
        student.favoriteStu.add(Integer.valueOf(stringTokenizer.nextToken()));
      }
      students[i] = student;
    }

    for (int i=0; i<students.length; i++){
      oneCondition(i);
    }
    satisfy();


    System.out.println(answer);
  }
  static void oneCondition(int i){
    ArrayList<int[]> tmp = new ArrayList<>();
    int max = Integer.MIN_VALUE;

    for (int j=0; j<N; j++){
      for (int k=0; k<N; k++){
        int count = 0;
        if (visit[j][k])continue;

        for (int l=0; l<4; l++){
          int ny = j+dy[l];
          int nx = k+dx[l];

          if (ny<0||nx<0||ny>N-1||nx>N-1){
            continue;
          }
          if (students[i].favoriteStu.indexOf(arr[ny][nx])>-1){
            count++;
          }
        }
        ;
        if (max<count){
          max = count;
          tmp.clear();
          tmp.add(new int[]{j,k});
        } else if (max==count) {
          tmp.add(new int[]{j,k});
        }
      }
    }
    if (tmp.size()>1){

      twoCondition(tmp,i);
    }
    else {
      arr[tmp.get(0)[0]][tmp.get(0)[1]] = students[i].num;
      visit[tmp.get(0)[0]][tmp.get(0)[1]] = true;
    }
  }

  static void twoCondition(ArrayList<int[]> arrayList, int i){

    ArrayList<int[]> tmp = new ArrayList<>();
    int max = Integer.MIN_VALUE;

    for (int j=0; j<arrayList.size(); j++){
      int count = 0;
      int y = arrayList.get(j)[0];
      int x = arrayList.get(j)[1];

      for (int k=0; k<4; k++){
        int ny = y+dy[k];
        int nx = x+dx[k];
        if (ny<0||nx<0||ny>N-1||nx>N-1){
          continue;
        }
        if (arr[ny][nx]==0){
          count++;
        }
      }
      if (max<count){
        max = count;
        tmp.clear();
        tmp.add(new int[]{y,x});
      }
      else if (max==count){
        tmp.add(new int[]{y,x});
      }
    }
    Collections.sort(tmp, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0]==o2[0]){
          return o1[1]-o2[1];
        }
        return o1[0]-o2[0];
      }
    });
    arr[tmp.get(0)[0]][tmp.get(0)[1]] = students[i].num;
    visit[tmp.get(0)[0]][tmp.get(0)[1]] = true;
  }

  static void satisfy(){
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++){
        int count = 0;
        Student student = students[map.get(arr[i][j])];

        for (int k=0; k<4; k++){
          int ny = i+dy[k];
          int nx = j+dx[k];

          if (ny<0||nx<0||ny>N-1||nx>N-1){
            continue;
          }
          if (student.favoriteStu.indexOf(arr[ny][nx])>-1){
            count++;
          }
        }
        switch (count){
          case 0 : answer+=0;
          break;
          case 1 : answer+=1;
          break;
          case 2 : answer+=10;
          break;
          case 3 : answer+=100;
          break;
          case 4 : answer+=1000;
          break;
        }
      }
    }
  }
  static class Student{
    int num;
    ArrayList<Integer> favoriteStu;

  }
}