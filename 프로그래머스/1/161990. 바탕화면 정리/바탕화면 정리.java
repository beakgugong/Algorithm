import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int rowMax = Integer.MIN_VALUE;
        int rowMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        int colMin = Integer.MAX_VALUE;
        
        
        for(int i=0; i<wallpaper.length; i++){
            if(wallpaper[i].indexOf('#')>=0&&colMin>wallpaper[i].indexOf('#')){
                colMin = wallpaper[i].indexOf('#');
                System.out.println(colMin);
            }
            if(wallpaper[i].indexOf('#')>=0&&colMax<wallpaper[i].lastIndexOf('#')){
                colMax = wallpaper[i].lastIndexOf('#');
            }
        }
        answer[1] = colMin;
        answer[3] = colMax+1;
        for(int i=0; i<wallpaper.length; i++){
            if(wallpaper[i].indexOf('#')>=0){
                answer[0] = i;
                break;
            }
        }
        for(int i=wallpaper.length-1; i>=0; i--){
            if(wallpaper[i].indexOf('#')>=0){
                answer[2] = i+1;
                break;
            }
        }
        
        return answer;
    }
}