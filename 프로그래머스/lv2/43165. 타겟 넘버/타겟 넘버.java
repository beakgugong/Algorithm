class Solution {
    public int result = 0;
    public int solution(int[] numbers, int target) {
     
        dfs(0,0,numbers, target);   
     
        return result;
    }
    private void dfs(int i, int sum, int[] numbers, int target){
        if(numbers.length==i && sum==target){
            result++;
            return;
        }
        if(numbers.length<=i){
            return;
        }
        dfs(i+1, sum+numbers[i], numbers,target);
        dfs(i+1, sum-numbers[i], numbers,target);
        
    }
}