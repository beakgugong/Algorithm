class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        int next_count = Integer.bitCount(n+1);
        int next_number = n+1; 
        while(true)
        {
            if(count==next_count)break;
            else{
                next_number++;
                next_count=Integer.bitCount(next_number);
            }
        }
        answer = next_number;
        return answer;
    }
}