import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long maxTime = (long)times[0]*n;
        long minTime = 1;
        
        while(minTime<=maxTime){
            long midTime = (maxTime+minTime)/2;
            long tmp_person = 0;
            
            for(int i=0; i<times.length; i++){
                tmp_person += midTime/times[i];
                if(tmp_person>n){
                    break;
                }
            }
            if(tmp_person>=n){
                maxTime = midTime-1;   
            }   
            else{
                minTime = midTime+1;
            }
            
        }
        
        return minTime;
    }
}
