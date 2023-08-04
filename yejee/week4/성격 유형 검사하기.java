import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] type = {'R','T','C','F','J','M','A','N'};
        char[] answer = {'R', 'C', 'J', 'A'};
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for(int i = 0; i < 8 ; i++){
            hashmap.put(type[i], 0);
        }
        
        for(int i = 0; i < survey.length ; i++){
            if(choices[i] < 4){
                hashmap.put(survey[i].charAt(0), hashmap.get(survey[i].charAt(0)) + 4 - choices[i]);
            }
            else if(choices[i] > 4){
                hashmap.put(survey[i].charAt(1), hashmap.get(survey[i].charAt(1)) + choices[i] - 4);
            }
            else {
                hashmap.put('-', 0);
            }
        }
        if(hashmap.get('R') < hashmap.get('T'))
            answer[0] = 'T';
        if(hashmap.get('C') < hashmap.get('F'))
            answer[1] = 'F';
        if(hashmap.get('J') < hashmap.get('M'))
            answer[2] = 'M';
        if(hashmap.get('A') < hashmap.get('N'))
            answer[3] = 'N';
        return new String(answer); 
    }
} 