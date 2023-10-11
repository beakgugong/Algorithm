class Solution {
    public int[] solution(int n, long left, long right) {
        int count = (int)(right-left)+1;
        int[] answer = new int[count];

        
        
        for (int i = 0; i < answer.length; i++) {
            int y = (int)(left / n + 1);
            int x = (int)(left % n + 1);
            left++;
            answer[i] = Math.max(y, x);
        }

        
        return answer;
    }
}