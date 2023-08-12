import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int num1 = 0;
        int answer1 = 0;
        int[] two = {2,1,2,3,2,4,2,5};
        int num2 = 0;
        int answer2 = 0;
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int num3 = 0;
        int answer3 = 0;
        for(int i=0; i<answers.length; i++){
            if(num1>4){
                num1=0;
            }
            if(answers[i]==one[num1]){
                answer1++;
            }
            num1++;
            if(num2>7){
                num2=0;
            }
            if(answers[i]==two[num2]){
                answer2++;
            }
            num2++;
            if(num3>9){
                num3=0;
            }
            if(answers[i]==three[num3]){
                answer3++;
            }
            num3++;
        }
       
        if(answer1>answer2&&answer1>answer3)answer.add(1);
        else if(answer2>answer1&&answer2>answer3)answer.add(2);
        else if(answer3>answer1&&answer3>answer2)answer.add(3);
        else if(answer1==answer2&&answer1>answer3){
            answer.add(1);
            answer.add(2);
        }
        else if(answer1==answer3&&answer1>answer2){
            answer.add(1);
            answer.add(3);
        }
        else if(answer2==answer3&&answer3>answer1){
            answer.add(2);
            answer.add(3);
        }
        else if(answer1==answer2&&answer1==answer3){
            answer.add(1);
            answer.add(2);
            answer.add(3);
        }
        
        return answer;
    }
}