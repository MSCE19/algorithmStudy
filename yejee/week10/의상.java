import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int count = 0;
        
        Map<String, Integer> clothesCnt = new HashMap<>();
        for(int i = 0 ; i < clothes.length ; i++){
            count = 0;
            if(clothesCnt.containsKey(clothes[i][1])){
                count = clothesCnt.get(clothes[i][1]);
            }
            clothesCnt.put(clothes[i][1], count + 1);
        }
        
        for(Map.Entry<String, Integer> entry : clothesCnt.entrySet()){
            answer *= entry.getValue() + 1;
        }
        answer -= 1;
        
        return answer;
    }
}