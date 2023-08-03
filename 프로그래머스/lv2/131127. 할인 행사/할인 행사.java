import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int count = 0;
        Map<String,Integer> menu = new HashMap<>(want.length);
        Map<String,Integer> mart = new HashMap<>(want.length);
        for(int i=0; i<want.length; i++){
            menu.put(want[i],number[i]);
        }
        
        for(int i=0; i<discount.length-9; i++){
            for(int j=i; j<i+10; j++){
                try{
                    mart.put(discount[j], mart.get(discount[j])+1);
                }
                catch(NullPointerException e){
                    mart.put(discount[j], 1);
                }
            }
            for(int k=0; k<want.length; k++){
                if(menu.get(want[k])==mart.get(want[k])){
                    count++;
                }
                else break;
            } 
            if(count==want.length){
                answer+=1;
            }
            count=0;
            mart.clear();
        }
        return answer;
     }
}