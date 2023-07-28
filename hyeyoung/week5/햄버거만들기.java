package hyeyoung.week5;

import java.util.LinkedList;

public class 햄버거만들기 {
}

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 삭제 속도 빠른 linkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i<ingredient.length; i++) {
            linkedList.add(ingredient[i]);
            if(linkedList.size() > 3
                    && linkedList.get(linkedList.size()-4) == 1
                    && linkedList.get(linkedList.size()-3) == 2
                    && linkedList.get(linkedList.size()-2) == 3
                    && linkedList.get(linkedList.size()-1) == 1) {
                answer++;
                for(int j = 0; j<4; j++) {
                    linkedList.remove(linkedList.size()-1);
                    //1, 2, 3, 1이 모두 지워 진 후 다시 2, 1에 이후 ingredient[i] 추가
                }
            }
        }
        return answer;
    }
}