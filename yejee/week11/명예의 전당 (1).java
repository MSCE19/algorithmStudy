import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> topRanks = new ArrayList<>();
        int lowest = 0;
        int rank = 0;
        
        //첫번째는 1일차 출연자의 점수
        answer[0] = score[0];
        lowest = score[0];
        topRanks.add(score[0]);        
        
        for(int i = 1 ; i < score.length ; i++){
            if(i < k){
                topRanks.add(score[i]);
            }
            else if(score[i] > lowest){
                topRanks.remove(Integer.valueOf(lowest));
                topRanks.add(score[i]);
            }
            lowest = Collections.min(topRanks);
            answer[i] = lowest;
        }
        
        return answer;
    }
}