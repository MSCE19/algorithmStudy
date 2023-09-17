class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0; // 맞춘 번호
        int zero = 0; // 알아볼 수 없는 번호
        
        for(int i : lottos){
            // 번호를 알아볼 수 없는 경우
            if(i == 0) zero++;
            else {
                for(int j : win_nums){  
                    if(i == j){
                        win++;
                        break;
                    }
                }
            }
        }
        
        answer[0] = Math.min(7 - (win + zero), 6);
        answer[1] = Math.min(7 - win, 6);
        return answer;
    
    }
}
