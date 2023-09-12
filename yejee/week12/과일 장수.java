import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int BoxScore = 0;
        ArrayList<Integer> appleScore = new ArrayList<>();
        
        for(int i = 0 ; i < score.length ; i++){
            appleScore.add(score[i]);
        }
        Collections.sort(appleScore, Collections.reverseOrder());
        
        for(int i = 0 ; i < score.length - score.length % m ; i++){
            if((i+1) % m == 0){
                BoxScore = appleScore.get(i);
                answer += appleScore.get(i) * m;
            }
        }
        
        return answer;
    }
}