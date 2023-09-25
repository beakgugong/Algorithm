import java.util.*;

class Solution {
    
    final char[] words = {'A', 'E', 'I', 'O', 'U'};
    final int MAX_LENGTH = 5;
        
    public int solution(String word) {
        int answer = 0;
        
        List<String> elements = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            dfs(elements, String.valueOf(words[i]));
        }    
        
        for(int i=0; i<elements.size(); i++){
            if(elements.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    void dfs(List<String> elements, String str){
        if(str.length() > MAX_LENGTH) return;
        
        if(!elements.contains(str)) elements.add(str);
    
        for(int i=0; i<words.length; i++){
            dfs(elements, str+words[i]);
        }
    }
}