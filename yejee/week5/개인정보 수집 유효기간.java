import java.util.HashMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int[] temp = new int[privacies.length];
        HashMap<Character, Integer> terms_hash = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate Today = LocalDate.parse(today, formatter);
        LocalDate due_date = LocalDate.now();
        char priv_term;
        int result_len = 0;
        
        // terms 배열을 약관 종류가 키, 유효기간을 값으로 갖는 해시맵으로 변환
        for(int i=0 ; i < terms.length ; i++){
            terms_hash.put(terms[i].charAt(0), Integer.valueOf(terms[i].substring(2)));
        }
        for(int i=0 ; i < privacies.length ; i++){
            due_date = LocalDate.parse(privacies[i].substring(0, 10), formatter);
            priv_term = privacies[i].charAt(11);
            
            due_date = due_date.plusMonths(terms_hash.get(priv_term));
            due_date = due_date.minusDays(1);
            if(due_date.isBefore(Today)){
                temp[result_len] = i+1;
                result_len++;
            }
        }
        answer = new int[result_len];
        for(int i=0 ; i < result_len ; i++){
            answer[i] = temp[i];
        }
        return answer;
    }
}