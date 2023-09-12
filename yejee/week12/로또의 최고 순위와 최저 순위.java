import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int sameNumCnt = 0;
        
        ArrayList<Integer> lottosList = new ArrayList<>();
        
        for(int i = 0 ; i < 6 ; i++){
            lottosList.add(lottos[i]);
            if(lottos[i] == 0)
                zeroCnt++;
        }
        
        for(int i = 0 ; i < 6 ; i++){
            if(lottosList.contains(win_nums[i]))
                sameNumCnt++;
        }
        
        if(sameNumCnt + zeroCnt == 0)
            answer[0] = 6;
        else
            answer[0] = 7 - (sameNumCnt + zeroCnt);
        if(sameNumCnt == 0)
            answer[1] =6;
        else
            answer[1] = 7 - sameNumCnt;
        
        
        return answer;
    }
}