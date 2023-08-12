import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

    
        Arrays.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String one, String two) {
                if(one.charAt(n)>two.charAt(n)){
                    return 50;
                }
                else if(one.charAt(n)<two.charAt(n)){
                    return -50;
                }
                else{
                    return one.compareTo(two);
                }
            }
        });
        
        return strings;
    }
}