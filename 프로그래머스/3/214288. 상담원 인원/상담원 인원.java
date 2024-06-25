import java.util.*;

class Solution {
    List<List<Integer>> orders = new ArrayList<>(); 
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 999999999;
        Integer[] area = new Integer[k+1];
        Arrays.fill(area,1);
        backtracking(n-k,1,new ArrayList<Integer>(Arrays.asList(area)));
        
        for(List<Integer> order : orders){
            answer = Math.min(answer,simulation(k,order,reqs));
        }
        return answer;
    }
    void backtracking(int remain, int idx, List<Integer> area){
        if(remain <= 0){
            orders.add(area);
            return;
        }
        
        for(int i = idx; i < area.size(); i++){
            area.set(i,area.get(i)+1);
            backtracking(remain-1,i,new ArrayList<Integer>(area));
            area.set(i,area.get(i)-1);
        }
    }
    
    int simulation(int k, List<Integer> order, int[][] reqs){
    
    
        PriorityQueue<Integer>[] pq = new PriorityQueue[k+1];
        int result = 0;
        
        for(int i = 1; i <= k; i++) {
        
            pq[i] = new PriorityQueue<Integer>();
            for(int j = 0; j < order.get(i); j++) pq[i].add(0);
        }
        
        for(int[] req : reqs){
            int arrive = req[0];
            int time = req[1];
            int idx = req[2]; 
        
            int picked = pq[idx].poll();
            
            
            if(picked > arrive) {
                result += picked-arrive;
                pq[idx].add(picked+time);
            }
            
            else if(picked < arrive){
                pq[idx].add(arrive+time);
            }
        
            else{
                pq[idx].add(picked+time);
            }
        }
        
        return result;
    }
}