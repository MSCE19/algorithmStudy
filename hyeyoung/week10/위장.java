import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            String cloth_type = clothes[i][1];
            hash.put(cloth_type, hash.getOrDefault(cloth_type, 1) + 1);
        }

        for (String key : hash.keySet()) {
            answer *= hash.get(key);
        }

        return answer - 1;
    }
}
