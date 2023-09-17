import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length;
        Arrays.sort(score);
        for(int i = 1; i <= len / m; i++ ){
            answer  += score[len - m*i] * m ;
        }
        
        return answer;
    }
}
