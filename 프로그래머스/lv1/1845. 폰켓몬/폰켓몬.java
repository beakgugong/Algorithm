import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length/2;
     
        HashMap<Integer,Integer> hash = new HashMap<>(nums.length);
        
        for(int i=0; i<nums.length; i++){
            hash.put(nums[i],i);
        }
        if(hash.size()<=half){
            answer= hash.size();
        }
        else {
            return half;
        }
        return answer;
    }
}