import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        for(int i=0; i<cards1.length; i++){
            que1.add(cards1[i]);    
        }
        for(int i=0; i<cards2.length; i++){
            que2.add(cards2[i]);    
        }
        for(int i=0; i<goal.length; i++){
            if(goal[i].equals(que1.peek())){
                que1.remove();
            }
            else if(goal[i].equals(que2.peek())){
                que2.remove();
            }
            else return "No";
        }
        return answer;
    }
}