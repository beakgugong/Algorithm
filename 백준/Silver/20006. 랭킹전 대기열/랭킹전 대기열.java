import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());
    User[] users = new User[p];
    ArrayList<Map<Integer, ArrayList<String>>> arrayList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    
    for (int i = 0; i < p; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(stringTokenizer.nextToken());
      String name = stringTokenizer.nextToken();

      users[i] = new User(name, level);
      map.put(name, level);
    }

    
    for (int i = 0; i < p; i++) {
      boolean added = false; 
      for (Map<Integer, ArrayList<String>> tmp : arrayList) {
        int firstLevel = tmp.keySet().stream().findFirst().get();
        if (Math.abs(users[i].level - firstLevel) <= 10 && tmp.get(firstLevel).size() < m) {
          
          tmp.get(firstLevel).add(users[i].nickname);
          added = true;
          break;
        }
      }
      if (!added) {
        Map<Integer, ArrayList<String>> newRoom = new HashMap<>();
        ArrayList<String> userList = new ArrayList<>();
        userList.add(users[i].nickname);
        newRoom.put(users[i].level, userList);
        arrayList.add(newRoom);
      }
    }
    
    for (Map<Integer, ArrayList<String>> tmp : arrayList) {
      int firstLevel = tmp.keySet().stream().findFirst().get();
      if (tmp.get(firstLevel).size() == m) {
        System.out.println("Started!");
      } else {
        System.out.println("Waiting!");
      }

      Collections.sort(tmp.get(firstLevel));
      for (String s : tmp.get(firstLevel)) {
        System.out.println(map.get(s) + " " + s);
      }
    }
  }

  static class User {
    String nickname;
    int level;

    public User(String nickname, int level) {
      this.nickname = nickname;
      this.level = level;
    }
  }
}
