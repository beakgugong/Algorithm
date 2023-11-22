import java.util.*;
class Solution {
    public int[] solution(String s) {
    
        String[] str = s.split("}");
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<str.length; i++){
            str[i] = str[i].replaceAll("\\{","");
        }
        
        Arrays.sort(str, (String s1, String s2) -> s1.length() - s2.length());
        for(int i=0; i<str.length; i++){
            String[] sstr = str[i].split(",");
            for(int j=0; j<sstr.length; j++){
                if((!sstr[j].equals(""))&&list.indexOf(sstr[j])==-1){
                    list.add(sstr[j]);
                }
            }
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}