import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            rank.put(players[i],i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int num = rank.get(callings[i]);
            swap(rank, players, num, num - 1);
        }
        
        for(String key : rank.keySet()){
            answer[rank.get(key)] = key;
        }
        return answer;
    }
    private void swap(Map<String, Integer> rank, String[] players, int i, int j) {
        String temp = players[i];
        players[i] = players[j];
        players[j] = temp;

        rank.put(players[i], i);
        rank.put(players[j], j);
    }
}