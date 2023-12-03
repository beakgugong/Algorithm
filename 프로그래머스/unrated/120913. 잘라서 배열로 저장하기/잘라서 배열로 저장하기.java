class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer;
        String newString;
        if(my_str.length()%n!=0){
            answer = new String[my_str.length()/n+1];
        }
        else
            answer = new String[my_str.length()/n];
        
        newString = my_str.substring(0,n);
        answer[0] = newString;
        for(int i=1; i<answer.length; i++){
            try{
                newString = my_str.substring(n*i,n*(i+1));
            }
            catch(StringIndexOutOfBoundsException e){
                newString = my_str.substring(n*i, my_str.length());
            }
            answer[i] = newString;
        }
        return answer;
    }
}