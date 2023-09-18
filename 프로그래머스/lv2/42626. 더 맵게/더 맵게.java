import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            
            int min = q.poll();
            int second = q.poll();

            int mixHot = min + (second * 2);
            q.add(mixHot);
            count++;
            if(q.size() <= 1 || q.peek() > K) break;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}