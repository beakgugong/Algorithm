class Solution {
    public int[] solution(String s) {
        int count=0;
        int zero=0;
        String binary="";
        StringBuffer str = new StringBuffer(s);
        int leng = s.length();
        
        
        while(!binary.equals("1")){
            for(int i=0; i<leng; i++){
                if(str.charAt(i)=='0'){
                    zero++;
                    
                }
            }
            String a = str.toString().replaceAll("0","");
            int num = a.length();
            binary = Integer.toBinaryString(num);
            str.setLength(0);
            str.append(binary);
            leng = binary.length();
            count++;
        }
        int[] answer = {count,zero};
        return answer;
    }
}