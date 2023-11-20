class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int count = 0;
        String[] words = {"aya","ye","woo","ma"};
        String[] sequence = {"ayaaya","yeye","woowoo","mama"};
        
        for(String word : babbling){
            for(String w : sequence){
                if(word.contains(w)){
                    word= word.replaceAll(w," ");
                }
                babbling[count] = word;
            }
            
            for(String w : words){
                if(word.contains(w)){
                    word= word.replaceAll(w,",");
                }
                babbling[count] = word;
            }
            count++;
        }
        
        for(String word :babbling){
            word = word.replaceAll(",","");
            if(word.equals("")){
                answer++;
            }
        }
        return answer;
    }
}