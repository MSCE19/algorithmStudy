package algorithmStudy;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<players.length; i++)
            map.put(players[i], i);
        
        for(int i=0; i<callings.length; i++){
            int index = map.get(callings[i]);
            
            players[index] = players[index-1];
            players[index-1] = callings[i];
            
            map.put(players[index], index);
            map.put(players[index-1], index-1);
        } 
        
        return players;
    }
}