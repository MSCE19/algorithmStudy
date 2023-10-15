package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for(int i : topping)
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        
        for(int i=0; i<topping.length-1; i++){
            if(map1.containsKey(topping[i]) && map1.get(topping[i])>0)
                map1.put(topping[i], map1.get(topping[i]) - 1);
            
            if(map1.get(topping[i])==0)
                map1.remove(topping[i]);
            
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
            
            if(map1.size()==map2.size())
                answer++;            
        }
        
        return answer;
    }
}