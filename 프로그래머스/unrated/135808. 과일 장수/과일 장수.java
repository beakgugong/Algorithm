import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int num = 0;
        Arrays.sort(score);
        for(int i=1; i<=score.length/m; i++){
        num = score[score.length-i*m];
        answer+=num*m;
        }
        System.out.println(num);
        return answer;
    }
}