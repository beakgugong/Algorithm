import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer= new int[score.length];
        Integer[] legend = new Integer[k];
        
        for(int i=0; i<k; i++){
            legend[i] = 2000;
        }
        for(int i=0; i<score.length&&i<k; i++){
            legend[i] = score[i];
            Arrays.sort(legend, Collections.reverseOrder());
            answer[i] = legend[k-1];
            Arrays.sort(legend);
        }
        Arrays.sort(legend, Collections.reverseOrder());
        for(int i=k; i<score.length; i++){
            if(legend[k-1]<score[i]){
                legend[k-1] = score[i];
                Arrays.sort(legend, Collections.reverseOrder());
                answer[i] = legend[k-1];
            }
            else{
                answer[i] = legend[k-1];
            }
        }
        
        
        return answer;
    }
}