import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int numA = Integer.valueOf(stringTokenizer.nextToken());
    int numB = Integer.valueOf(stringTokenizer.nextToken());
    Set<Integer> A = new HashSet<>();
    Set<Integer> B = new HashSet<>();

    stringTokenizer = new StringTokenizer(br.readLine());
    for (int i=0; i<numA; i++){
      A.add(Integer.valueOf(stringTokenizer.nextToken()));
    }
    stringTokenizer = new StringTokenizer(br.readLine());
    for (int i=0; i<numB; i++){
      B.add(Integer.valueOf(stringTokenizer.nextToken()));
    }

    int count = 0;
    Iterator<Integer> iterator = A.iterator();
    while (iterator.hasNext()) {
      int tmp = iterator.next();
      if (B.remove(tmp)){
        count++;
      }
    }

    int answer = B.size()+(A.size()-count);
    System.out.println(answer);
  }
}
