class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer str = new StringBuffer();
        int count = 0;
        while(str.length()<(t*m)){
            str.append(Integer.toString(count,n));
            count++;
        }
        
        int num = 0;
        while(answer.length()<=t-1){ 
            answer += str.charAt((m*num)+p-1);
            num++;
        }
    
        return answer.toUpperCase();
    }
}