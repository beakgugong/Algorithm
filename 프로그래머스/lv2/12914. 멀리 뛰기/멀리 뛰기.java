class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] fib = new long[n+2];
        fib[1]=1L;
        fib[2]=2;
        
        for(int i=3; i<=n; i++){
            fib[i]=(fib[i-1]+fib[i-2])%1234567;
        }
        answer = fib[n];
        return answer;
    }
}