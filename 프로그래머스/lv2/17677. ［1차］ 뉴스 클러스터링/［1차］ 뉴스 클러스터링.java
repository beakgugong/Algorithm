import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase(); 
		str2 = str2.toUpperCase();
		double ans;
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();

		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> its = new ArrayList<>();
        
		for(int i = 0; i < str1.length()-1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i+1);

			
			if(Character.isLetter(str1.charAt(i)) &&
               Character.isLetter(str1.charAt(i+1))) {
				arr1.add(Character.toString(str1.charAt(i))
                          + Character.toString(str1.charAt(i+1)));
			}
        
		}

	
		for(int i = 0; i < str2.length()-1; i++) {
			if(Character.isLetter(str2.charAt(i)) &&
               Character.isLetter(str2.charAt(i+1))) {
				arr2.add(Character.toString(str2.charAt(i))
                          + Character.toString(str2.charAt(i+1)));
			}
        }

		
		Collections.sort(arr1);
		Collections.sort(arr2);
		
		
		for(String s : arr1) {
			if(arr2.remove(s)) { 
				its.add(s);
			}
			union.add(s);
		}
		
		
		for(String s : arr2) {
            union.add(s);
		}
        if(union.size()==0){
            answer=65536;
        }
        else{
            ans = (double)its.size()/(double)union.size();
            answer = (int)(ans*65536);
        }
        
        return answer;
    }
}