import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Character[] charArr ={'A','B','C','D','E','F','G','H','I','J','K','L','N','M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Map<Character, Integer> min = new HashMap<>();
        
        for(int i=0; i<26; i++){
            min.put(charArr[i],1000);
            for(int j=0; j<keymap.length; j++){
                if(keymap[j].indexOf(charArr[i])>=0&&min.get(charArr[i])>keymap[j].indexOf(charArr[i])){
                    min.put(charArr[i],keymap[j].indexOf(charArr[i])+1);
                }
            }
            
        }
        
        for(int i=0; i<targets.length; i++){
            int num = 0;
            for(int j=0; j<targets[i].length(); j++){
                num+=min.get(targets[i].charAt(j));
            }
            if(num>=1000){
                answer[i]=-1;
            }
            else
                answer[i]=num;
        }
        return answer;
    }
}