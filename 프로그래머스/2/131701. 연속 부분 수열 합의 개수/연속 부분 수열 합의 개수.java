import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> answer = new HashSet<>();
        
        for(int i = 1; i <= elements.length; i++){
            int val = 0;
       
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<i; j++){
                 val += elements[j% elements.length];
                 set.add(val);
            }

            for(int j = 0; j < elements.length; j++){
                val -= elements[j% elements.length];
                val += elements[(j + i) % elements.length];
                set.add(val);
            }
            answer.addAll(set);
        }
        
        
        return answer.size();
    }
}