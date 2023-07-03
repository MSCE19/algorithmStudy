package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(String dartResult) { 
        int answer = 0;
        int temp = 0;  
        int j = 0;    // score 인덱스  
        ArrayList<Integer> score = new ArrayList<Integer>();

        for(int i=0; i<dartResult.length(); i++){
            if(Character.isDigit(dartResult.charAt(i))){  // 문자가 숫자인지 확인
                if(Character.isDigit(dartResult.charAt(i+1))){  // 그 다음 문자도 숫자인 경우(10인경우)
                    temp = Integer.parseInt(dartResult.substring(i, i+2));  
                    i++; // 이 경우 1을 증가시킴. 10이므로 1 뒤의 0에 대해선 건너뛰어야 하므로
                }
                else
                    temp = dartResult.charAt(i) - '0';
                score.add(temp);  // 리스트에 숫자 추가
                j++; // 리스트 인덱스 증가
            }
            else if(dartResult.charAt(i)=='#')
                score.set(j-1, score.get(j-1) * (-1));
            else if(dartResult.charAt(i)=='*'){
                score.set(j-1, score.get(j-1) * 2);
                if(j>=2)  // *이 맨 처음에 등장한 것이 아니라면 (1S* 이런 경우가 아닐 때, ex 1S2D*)
                    score.set(j-2, score.get(j-2) * 2);   // 그 전 것도 적용
            }
            else
                score.set(j-1, (int) sdt(dartResult.charAt(i), score.get(j-1))); // 그 외, S D T 일 경우 함수호출
        }
        
        for(int i = 0; i<score.size(); i++)  // 리스트의 값들을 전부 합해줌
            answer += score.get(i);
        
        return answer;
    }
    
    public double sdt(char c, int score){  // S D T의 경우에 대해 계산
        if(c == 'S')
            return score;
        else if(c == 'D')
            return Math.pow(score, 2);
        else
            return Math.pow(score, 3);
    }
}
