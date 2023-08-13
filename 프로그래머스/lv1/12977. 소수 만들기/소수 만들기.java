import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int leng = nums.length*(nums.length-1)*(nums.length-2)/6;
        int arrNum = 0;
        int[] store = new int[leng];
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    store[arrNum] = nums[i]+nums[j]+nums[k];
                    arrNum++;
                } 
            }
        }
        int count = store.length;
        for(int i=0; i<store.length; i++){
            for(int j=2; j<=Math.sqrt(store[i]); j++){
                if(store[i]%j==0){
                    count--;
                    break;
                }
            }
        }
        answer = count;
        return answer;
    }
}