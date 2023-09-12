package algorithmStudy;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String i : completion)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(String i : participant){
            if(map.containsKey(i)==false || map.get(i)==0){
                answer = i;
                break;
            }
            else
                map.put(i, map.get(i)-1);
        }
        
        
        return answer;
    }
}