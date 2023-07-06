package hyeyoung.week2;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //문제에서 주어진 person 1, 2, 3의 답
        int s1 = 0; int s2 = 0; int s3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(person1[i % person1.length] == answers[i]) s1++; //answer의 i번째 답과 person1의 i번째 답이 같다면 person1의 점수 + 1
            if(person2[i % person2.length] == answers[i]) s2++; //상동
            if(person3[i % person3.length] == answers[i]) s3++; //상동
        }

        int max = Math.max(Math.max(s1, s2), s3);   //s1, s2, s3를 비교하여 가장 큰 값을 찾음
        List<Integer> list = new ArrayList<>();
        if(max == s1) list.add(1);
        if(max == s2) list.add(2);
        if(max == s3) list.add(3);

        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
