import java.util.Arrays;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = {0, 0, 0};
        int n = 0; // score의 index용
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if ('0' <= ch && ch <= '9') {
                score[n] = ch - '0';
                if(dartResult.charAt(i + 1) == '0'){
                    score[n] *= 10;
                    i++;
                }
            }
            else if(ch == 'S' || ch == 'D' || ch == 'T'){ 
                score[n] = SDT(score[n], ch); //해당 기회의 점수 계산
                if(i != dartResult.length() - 1 && '0' <= dartResult.charAt(i + 1) && dartResult.charAt(i + 1) <= '9'){ // 여기에 해당하는 경우 상을 받지 않는다는 의미이므로 score의 index를 넘겨준다.
                    n++; 
                }
            }
            else if(ch == '*'){
                score = star(score, n);
                n++;
            }
            else{
                score[n] *= -1;
                n++;
            }
        }
        
        answer = score[0] + score[1] + score[2];
        return answer;
    }
    // 싱글 더블 트리플 계산하는 함수
    public int SDT(int score, char c){
        if(c == 'S')
            return score;
        else if(c == 'D')
            return score*score;
        else 
            return score*score*score;
    }
    // 스타상 계산하는 함수
    public int[] star(int[] score, int n){
        if(n == 0){
            score[n] *= 2;
        }
        else{
            score[n-1] *= 2;
            score[n] *= 2;
        }
        return score;
    }
}