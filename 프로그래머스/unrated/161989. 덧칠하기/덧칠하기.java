import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        Arrays.sort(section);
        int region = section[0]-1;
        for(int i=1; i<section.length; i++){
            if(section[i]-region>m){
                region = section[i]-1;
                answer++;
            }
            else if(section[i]-region<=m){
                
            }
        }
        
        
        return answer+1;
    }
}