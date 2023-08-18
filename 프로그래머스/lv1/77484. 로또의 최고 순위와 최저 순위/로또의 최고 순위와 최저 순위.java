import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
      
        int max = 7;
        int min = 7;
        for(int i=0; i<6; i++){
            if(lottos[i]==0){
                max--;
            }
            else{
                for(int j=0; j<6; j++){
                    if(lottos[i]==win_nums[j]){
                        max--;
                        min--;
                    }
                }
            }
        }
        if(max==7&&min==7){
            answer[0]=6;
            answer[1]=6;
        }
        else if(max==7){
            answer[0]=6;
            answer[1]=min;
        }
        else if(min==7){
            answer[0]=max;
            answer[1]=6;
        }
        else {
        answer[0]=max;
        answer[1]=min;
        }
        return answer;
    }
}