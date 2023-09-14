import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int diff = 0;
        int count = 1;
        boolean[] visited = new boolean[words.length];
        Map<String, Integer> map = new HashMap<>();
        System.out.println(visited[0]);
        Queue<String> que = new LinkedList<>();
        
        que.add(begin);
        while(!que.isEmpty()){
            begin = que.peek();
            if(begin.equals(target)){
                return map.get(begin);
            }
        for(int i=0; i<words.length; i++){
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j)!=words[i].charAt(j)){
                    diff++;
                }
            }
    
            if(diff==1&&visited[i]==false){
                que.add(words[i]);
                visited[i] = true;
                map.put(words[i],count);
            }
            diff=0;
            }
            count++;
            
            que.poll();
        }
     return answer;   
    }
    
}