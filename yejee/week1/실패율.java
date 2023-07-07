import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failure = new double[N]; // 각 스테이지별 실패율
        
        int total =  stages.length; // 스테이지에 도달한 플레이어의 수(분모)
        int player = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 (분자)
        double temp; //버블정렬용
        int index; //버블정렬용
        
        for(int i = 1; i <= N ; i++, player = 0){
            for(int j = 0 ; j < stages.length ; j++){ // i번째 스테이지에 머무르고 있는 플레리어 수 세기
                if(i == stages[j])
                    player++;
            }
            failure[i - 1] = (double) player/total;
            total -= player;
        }
        
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = i + 1;
        }
        
        // 스테이지랑 실패율을 같이 바꿀 방법이 생각안나서 이렇게 했는데 좀 별로인듯..
        // 실패율 버블 정렬해줄때 스테이지 번호도 함꼐 바꿔준다. 
        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = 0 ; j < N - 1 - i ; j++){
                if(failure[j] < failure[j+1]){
                    temp = failure[j];
                    failure[j] = failure[j+1];
                    failure[j+1] = temp;
                    index = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = index;
                }
            }   
        }
        return answer;
    }
}