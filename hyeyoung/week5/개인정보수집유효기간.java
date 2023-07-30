package hyeyoung.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {
}

class Solution1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> period = new HashMap<>();

        int date = getTotalDate(today);

        for(String t: terms){
            String[] term = t.split(" ");
            period.put(term[0], Integer.valueOf(term[1]));
        }

        for(int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            if(getTotalDate(privacy[0]) + (period.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }

        int[] intArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            intArray[i] = answer.get(i);
        }

        return intArray;
    }

    private int getTotalDate(String today){
        String[] date = today.split("\\.");

        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}