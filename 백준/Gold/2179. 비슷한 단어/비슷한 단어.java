import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.valueOf(br.readLine());
    String[] arr = new String[N];

    for (int i=0; i<N; i++){
      arr[i] = br.readLine();
    }

    int max = 0;
    String[] answer = new String[2];

    for (int i=0; i<N-1; i++){
      String tmp = arr[i];
      for (int j=i+1; j<N; j++){
        int len = tmp.length()<arr[j].length()?tmp.length():arr[j].length();
        int count = 0;

        for (int k=0; k<len; k++){
          if (tmp.charAt(k)==arr[j].charAt(k)){
            count++;
          }else {
            break;
          }
        }
        if (max<count){
          answer[0] = tmp;
          answer[1] = arr[j];
          max = count;
        }
      }
    }

    System.out.println(answer[0]);
    System.out.println(answer[1]);
  }
}