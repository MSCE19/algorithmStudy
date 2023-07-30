package hyeyoung.week5;

import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {
}

class Solution2 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            if(i != 0){
                String s1 = words[i - 1];
                String s2 = words[i];

                if(map.containsKey(s2) || s1.charAt(s1.length() - 1) != s2.charAt(0)){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;

                    return answer;
                }
            }
            map.put(words[i], 1);
        }

        return answer;
    }
}