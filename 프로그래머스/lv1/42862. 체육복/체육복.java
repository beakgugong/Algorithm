class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        
        for(int i=0; i<student.length; i++){
            student[i]=1;
            for(int j=0; j<lost.length; j++){
                if(i==lost[j]){
                    student[i]--;
                }
            }
            for(int k=0; k<reserve.length; k++){
                if(i==reserve[k]){
                    student[i]++;
                }
            }
        }
        for(int i=1; i<student.length; i++){
            if(student[i]==1||student[i]==2){
                answer++;
            }
            else if(student[i]==0){
                try{
                if(student[i-1]==2){
                    answer++;
                }
                else if(student[i+1]==2){
                    answer++;
                    student[i+1]--;
                }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        return answer;
    }
}