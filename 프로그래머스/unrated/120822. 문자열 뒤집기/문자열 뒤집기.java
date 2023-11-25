class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuffer str = new StringBuffer();
        
        for(int i=my_string.length()-1; i>=0; i--)
        {
            str.append(my_string.charAt(i));
        }
        return str.toString();
    }
}