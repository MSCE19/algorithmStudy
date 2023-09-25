package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int rank = 7;
        int zero = 0;
        Map<Integer, Integer> mapWin = new HashMap<Integer, Integer>();
                
        for(int i : win_nums)
            mapWin.put(i, 0);
        
        for(int i : lottos){
            if(mapWin.containsKey(i))
                rank--;
            if(i==0)
                zero++; 
        }
        if(rank==7)
            rank = 6;
        
        if(rank-zero<=1)
            answer[0] = 1;
        else
            answer[0] = rank-zero;
        answer[1] = rank;
        
        return answer;
    }
}
