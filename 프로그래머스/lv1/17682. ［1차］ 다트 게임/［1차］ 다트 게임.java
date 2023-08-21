import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int cal = 0;
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i)>=48&&dartResult.charAt(i)<=57){
                try{
                if(dartResult.charAt(i+1)>=48
                   &&dartResult.charAt(i+1)<=57){
                   answer+=cal;
                   arr.add(cal);
                   count++;
                   cal=10;
                   i+=1;
                }
                else{
                answer+=cal;
                arr.add(cal);
                count++;
                cal=0;
                cal = dartResult.charAt(i)-'0';
                System.out.println(cal);
                    }
                }
                catch(NullPointerException e){   
                } 
            }
            else if(dartResult.charAt(i)=='D'){
                cal*=cal;
            }
            else if(dartResult.charAt(i)=='T'){
                cal*=cal*cal;
            }
            else if(dartResult.charAt(i)=='*'){
                answer+=arr.get(count-1);
                cal*=2;
            }
            else if(dartResult.charAt(i)=='#'){
                cal*=-1;
            }
        }
        answer+=cal;
        return answer;
    }
}