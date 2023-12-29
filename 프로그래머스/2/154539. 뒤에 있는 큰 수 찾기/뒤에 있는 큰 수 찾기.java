import java.util.*;
class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        stack.add(numbers[numbers.length-1]);
        answer[numbers.length-1] = -1;
        
        for(int i=numbers.length-2; i>=0; i--){
            if(stack.peek()>numbers[i]){
                answer[i]=stack.peek();
                stack.add(numbers[i]);
            }
            else{
                answer[i] = inspect(numbers[i]);
            }
        }
        return answer;
    }
    public int inspect(int currentNum){
        int num;
        while(!stack.empty()){
            if(stack.peek() > currentNum){
                num = stack.peek();
                stack.add(currentNum);
                return num;
            }
            else{
                stack.pop();
            }
        }
        stack.add(currentNum);
        return -1;
    }
}