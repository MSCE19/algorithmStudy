package algorithmStudy;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<brown+yellow; i++){
            if((brown+yellow)%i==0){
                int h = i;
                int w = (brown+yellow)/i;
                
                if(yellow==(w-2)*(h-2)){ // 노란색 카펫 개수가 전체 카펫의 가로-2 * 세로-2와 같으면
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}