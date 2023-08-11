import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int count=0;
        Queue<String> que = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.add(words[0]);
        for(int i=1; i<words.length; i++){
            que.add(words[i]);
        }
        for(int i=0; i<words.length-1; i++){
            if(stack.contains(words[i+1])){
                System.out.println("haha");
                return cal(i, n , answer);
            }
            else if(words[i].charAt(words[i].length()-1)==que.peek().charAt(0)){
                stack.add(que.peek());
                que.remove(); 
            }
            else{
                return cal(i, n , answer);
            }
        }
        return answer;
    }
    public static int[] cal(int i, int n, int[] answer){
        if((i+2)%n==0){
                answer[0]=n;
                answer[1]=(i+2)/n;
            }
        else{ 
            answer[0]=(i+2)%n;
            answer[1] = (i+2)/n+1;
        }
        return answer;
    }
}