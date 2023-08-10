import java.util.*;
public class Solution
{
    public int solution(int bridge_length, int weight, int[] truck_weights)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int now = 0, sec = 1;
        for(int w : truck_weights)
        {
            if(!map.isEmpty() && map.firstKey() == sec)
                now -= map.remove(map.firstKey());

            while(w + now > weight)
            {
                sec = map.firstKey();
                now -= map.remove(map.firstKey());
            }

            map.put(sec + bridge_length, w);
            now += w;

            sec++;
        }

        return map.lastKey();
    }
}