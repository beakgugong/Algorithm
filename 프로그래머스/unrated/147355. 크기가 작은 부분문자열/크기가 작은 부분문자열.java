import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long len = t.length()-p.length()+1;
        
        for(int i=0; i<len; i++){
            if(Long.parseLong(p)>=
               Long.parseLong(t.substring(i,i+p.length())))answer++;
        }
        return answer;
    }
}