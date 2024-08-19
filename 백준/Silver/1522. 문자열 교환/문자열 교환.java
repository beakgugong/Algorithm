import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ab = br.readLine();
    int bCount = 0;
    int aCount = 0;
    int min = Integer.MAX_VALUE;

    for (int i=0; i<ab.length(); i++){
      if (ab.charAt(i)=='a'){
        aCount++;
      }
    }

    for (int i=0; i<ab.length(); i++){
      for (int j=i; j<i+aCount; j++){
        int tmp = j;
        if (tmp>=ab.length()){
          tmp%=ab.length();
        }
        if (ab.charAt(tmp)=='b')bCount++;
      }
      min = Math.min(min,bCount);
      bCount=0;
    }

    System.out.println(min);
  }
}