import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        int count = 1;
        
        for(String name : participant){
            count = 1;
            if(participantMap.containsKey(name))
                count = participantMap.get(name) + 1;
            participantMap.put(name, count);
        }
        
        for(String name : completion){
            if(participantMap.get(name) != 1)
                participantMap.put(name, participantMap.get(name) - 1);
            else
                participantMap.remove(name);
        }
        
        return participantMap.keySet().iterator().next();
    }
}