import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        
        String[] sstr = str.split("0");
        ArrayList<Long> change = new ArrayList<>();
        
        for(int i=0; i<sstr.length; i++){
            try{
            change.add(Long.parseLong(sstr[i]));
            }
            catch(NumberFormatException e){
            }
        }
        
        int num = 0;
        for(int i=0; i<change.size(); i++){
            if(change.get(i)==1){
                    continue;
                }
            for(int j=2; j<=Math.sqrt(change.get(i)); j++){
                
                if(change.get(i)%j==0){
                    num++;
                    break;
                }
            }
            if(num==0) answer++;
            else num=0;
        }
        return answer;
    }
}