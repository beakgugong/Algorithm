import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(bufferedReader.readLine());
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int delete = Integer.valueOf(bufferedReader.readLine());
    ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    for (int i=0; i<N; i++){
      tree.add(new ArrayList<>());
    }

    for (int i=0; i<N; i++){

      int tmp = Integer.valueOf(stringTokenizer.nextToken());
      if(tmp==-1){
        continue;
      }
      else {
        tree.get(tmp).add(i);
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(delete);
    while (!queue.isEmpty()){
      int tmp = queue.poll();
      for (int j = 0; j < tree.get(tmp).size(); j++) {

        queue.add(tree.get(tmp).get(j));
      }

      for (int i=0; i<tree.size(); i++){
        int num = tree.get(i).indexOf(tmp);
        if(tree.get(i).indexOf(tmp)!=-1)
        {
          tree.get(i).remove(num);
        }
      }

      tree.get(tmp).clear();
      tree.get(tmp).add(-1);
    }

    int answer = 0;
    for(int i=0; i< N; i++){
      if(tree.get(i).size()==0){
        answer++;
      }
    }

    System.out.println(answer);
    }
}