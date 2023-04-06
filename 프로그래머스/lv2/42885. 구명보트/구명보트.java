import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer=0,num=0,check = 0;
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(people);
        for(int weight : people){
            stack.push(weight);
        }
        while(!stack.empty()){
            if(num>=stack.size())break;
            if(people[num]+stack.peek()<=limit){
                num++;
                stack.pop();
            }
            ++answer;
            
            if(check!=num){
                check=num;
            }
            else{
                stack.pop();
            }
        }
        return answer;
    }
}
