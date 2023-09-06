class Solution {
    public String solution(String s) {
        String answer = " ";
                
        StringBuffer low = new StringBuffer(s.toLowerCase());
        if(low.charAt(0)>89){
            low.setCharAt(0, (char)(low.charAt(0)-32));
        }
        for(int i=0; i<low.length(); i++){
            try{
            if(low.charAt(i)==' '&&low.charAt(i+1)>89){
                low.setCharAt(i+1, (char)(low.charAt(i+1)-32));
            }
            }
            catch(StringIndexOutOfBoundsException e){
                return low.toString();        
            }
        }
        
        answer = low.toString();
        return answer;
    }
}