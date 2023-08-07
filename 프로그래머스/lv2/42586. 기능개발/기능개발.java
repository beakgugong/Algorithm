import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int answer = 0;
        int num=0;
        int check=0;
        ArrayList<Integer> arr = new ArrayList();
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            que.add(progresses[i]);
        }
        while(que.size()>0){
            for(int i=answer; i<progresses.length; i++){
                progresses[i]+=speeds[i];
            }
            while(check<progresses.length&&progresses[check]>=100){
               num++;
               check++;
            }
            if(num!=0){
            arr.add(num);
            for(int i=0; i<num; i++){
                que.poll();
                answer++;
                }
                num=0;
            }
            
            
        }
        
        return arr;
    }
}