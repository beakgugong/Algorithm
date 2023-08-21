class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int weight = 0;
        for(int i=2; i<=number; i++){
            for(int j=1; j<Math.sqrt(i); j++){
                if(i%j==0){
                    weight++;
                }
            }
            weight*=2;
            if(i%Math.sqrt(i)==0){
                weight++;
            }
            if(weight>limit){
                answer+=power;
            }
            else answer+=weight;
            weight=0;
        }
        answer+=1;
        return answer;
    }
}