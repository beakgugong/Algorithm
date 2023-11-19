import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        int[] answer = {};
        int count = 0;
        int personNumber = stages.length;
        Map<Integer, Double> store = new HashMap<>();
        
        for(int i=1; i<N+1; i++){
            for(int j : stages){
                if(j==i){
                    count++;
                }
            }
            if(count>0){
                store.put(i,(double)count/(double)personNumber);
                personNumber-=count;
                count=0;
                continue;
            }
            store.put(i,0.0);
        }
        List<Integer> keys = new ArrayList<>(store.keySet()); 
        Collections.sort(keys, (o1, o2) -> (store.get(o2).compareTo(store.get(o1))));
        
        System.out.print(keys);
        return keys;
    }
}