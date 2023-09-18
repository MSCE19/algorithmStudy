import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int min = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i< score.length; i++){
            if(list.size() < k){
                list.add(score[i]);
                Collections.sort(list);
                answer[i] = list.get(0);
            }else if(list.size() == k){
                min = list.get(0);
                if(min < score[i]){
                    list.remove(0);
                    list.add(score[i]);
                    Collections.sort(list);
                }
                answer[i] = list.get(0);
            }
        }
        return answer;
    }
}
