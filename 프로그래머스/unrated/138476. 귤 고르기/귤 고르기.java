import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer=0;
        int check = 1;
        int counter=0;
        int[] count=new int[tangerine.length] ;
        Arrays.sort(tangerine);

       
        for(int i=0; i<tangerine.length-1; i++){
            if(tangerine[i]==tangerine[i+1]){
                check++;
                if(i==(tangerine.length-2))count[counter]=check;
            }
            else{
                count[counter]=check;
                counter++;
                check=1;
            }
        }
        
        
        Integer[] arr = Arrays.stream(count).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<count.length; i++){
            System.out.println(arr[i]);
            if(k-arr[i]>0){
                answer++;
                k-=arr[i];
            }
            else if(k-arr[i]==0){
                answer++;
                break;
            }
            else if(i==0) return 1;
            else {
                answer++;
                break;
                }
        }
        
        
        return answer;
    }
}