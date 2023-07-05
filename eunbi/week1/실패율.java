package algorithmStudy;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();

        List<Integer> list = Arrays.stream(stages)
                        .boxed()
                        .collect(Collectors.toList()); //list로 변환  
        
        list.sort(Comparator.naturalOrder());        

        for(int i=1; i<=N; i++){
            int clear = 0;
            for(int j=0; j<list.size(); j++){
                if(list.get(j)>i)
                    clear++;
            }
            if (list.isEmpty() || list.get(list.size() - 1) < i) // 스테이지 도달 x일 때
                map.put(i, 0d);
            else 
                map.put(i, (double) (list.size() - clear) / list.size());
            
            while (list.size() > 0 && list.get(0) <= i) 
                list.remove(0);
        }

        List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = 0; i < sortedList.size(); i++)
            answer[i] = sortedList.get(i).getKey();
        
        return answer;
    }
}
