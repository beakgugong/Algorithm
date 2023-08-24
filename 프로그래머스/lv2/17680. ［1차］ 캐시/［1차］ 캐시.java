import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;
        LinkedList<String> link = new LinkedList<>();
        link.add(cities[0].toUpperCase());
        if(cacheSize==0){
            return cities.length*5;
        }
        for(int i=1; i<cities.length; i++){
            if(link.contains(cities[i].toUpperCase())){
                link.remove(link.indexOf(cities[i].toUpperCase()));
                link.add(cities[i].toUpperCase());
                System.out.println(answer);
                answer+=1;
            }
            else if(link.size()<cacheSize){
                link.add(cities[i].toUpperCase());
                answer+=5;
                System.out.println(answer);
            }
            else{
                link.remove();
                link.add(cities[i].toUpperCase());
                answer+=5;
            }
            
        }
        
        return answer;
    }
}