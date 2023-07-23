package algorithmStudy;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] result = new int[4];
        String[] kakao = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<survey.length; i++){
            if(choices[i]>4)  // 동의. 문자를 key로, 점수를 value로해서 map에 저장
                map.put(cToS(survey[i], 1), map.getOrDefault(cToS(survey[i], 1), 0) + choices[i]-4);
            else  // 비동의
                map.put(cToS(survey[i], 0), map.getOrDefault(cToS(survey[i], 0), 0) + Math.abs(choices[i]-4));
        }
        
        for(int i=0; i<8; i++)
            if(map.get(kakao[i])==null)
                map.put(kakao[i], 0); // 성격유형 점수가 비어있으면(null이면) 0으로 추가해줌
        
        
        for(int i=0; i<8; i=i+2){
            if(map.get(kakao[i]) >= map.get(kakao[i+1]))  
                answer = answer + kakao[i];
            else
                answer = answer + kakao[i+1];
        }
        
        return answer;
    }
    
    public String cToS(String s, int i){ // char를 String으로 변환
        return String.valueOf(s.charAt(i)); // (+문제 푼 뒤에 추가+ 다른사람 풀이 보니 map에 캐릭터형 넣을 수 있음....)
    }
}