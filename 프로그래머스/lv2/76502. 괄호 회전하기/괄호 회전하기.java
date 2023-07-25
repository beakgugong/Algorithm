import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += (check(s)) ? 1 : 0;
            s = s.substring(1, s.length()) + s.substring(0,1);
        }
        return answer;
    }
    public static boolean check(String str) {
        Stack<Character> ch = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') { ch.push(str.charAt(i)); } else {
                if (!ch.isEmpty()) {
                    char c = ch.pop(), s = str.charAt(i);
                    if(c == '(' && s == ')') { continue; }
                    else if(c == '{' && s == '}') { continue; }
                    else if(c == '[' && s == ']') { continue; }
                    else { return false; }
                } else {return false;}
            }
        }
        if(ch.isEmpty()) { return true; } else { return false; }
    }
}