import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
class Solution {
    public String solution(int a, int b) {
        LocalDate test = LocalDate.of(2016,a,b);
        DayOfWeek dayOfWeek = test.getDayOfWeek();
        String answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
    
        return answer.toUpperCase();
    }
}