package eunbi.week1;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        List<Integer> t = Arrays.stream(tangerine)
                        .boxed()
                        .collect(Collectors.toList()); //list·Î º¯È¯      
        
        HashMap<Integer, Integer> map = new HashMap<>();
         
        for (int i = 0; i < tangerine.length; i++)
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        
        
        List<Integer> list = new ArrayList<>(map.values());
        
        list.sort(Comparator.reverseOrder());        
            
        int i = 0;
        while(k>0){
            k = k - list.get(i);
            answer++;
            i++;
        }
        return answer;
        
    }
}
