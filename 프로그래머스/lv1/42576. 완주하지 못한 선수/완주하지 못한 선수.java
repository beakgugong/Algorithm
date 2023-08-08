import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        int one = 1;
        for(int i=0; i<participant.length; i++){
           Integer num = map.put(participant[i],1); 
           if(Objects.nonNull(num)){
               map.put(participant[i], num+1);
              
           }
        
           
        }
      
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);           
        }

        for(String i : map.keySet()){
            if(map.get(i)==1){
                answer=i;
                break;
            }
        }
        return answer;
    }
}