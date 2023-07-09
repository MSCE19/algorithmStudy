import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, Ascore(answers));
        map.put(2, Bscore(answers));
        map.put(3, Cscore(answers));
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        if(list.get(0) == list.get(2)){
            answer = new int[] {1,2,3};
        }
        else if(list.get(0) != list.get(1))
            answer = new int[] {getKey(map,list.get(0))};
        else if(getKey(map,list.get(2)) == 1)
            answer = new int[] {2,3};
        else if(getKey(map,list.get(2)) == 2)
            answer = new int[] {1,3};
        else
            answer = new int[] {1,2};
        return answer;
    }
    // 첫번째 수포자의 점수 계산
    public int Ascore(int[] answers){
        int score = 0;
        int ans;
        for(int i = 0; i < answers.length; i++){
            ans = i % 5 + 1;
            if (ans == answers[i])
                score++;
        }
        return score;
    }
    
    // 두번째 수포자의 점수 계산
    public int Bscore(int[] answers){
        int score = 0;
        int[] ans = {2,1,2,3,2,4,2,5};
        for(int i = 0; i < answers.length; i++){
            if (ans[i % 8] == answers[i])
                score++;
        }
        return score;
    }
    
    // 세번째 수포자의 점수 계산
    public int Cscore(int[] answers){
        int score = 0;
        int[] ans = {3,3,1,1,2,2,4,4,5,5};
        for(int i = 0; i < answers.length; i++){
            if (ans[i % 10] == answers[i])
                score++;
        }
        return score;
    }
    // value 값에 해당하는 key값 찾기
    private int getKey(HashMap<Integer, Integer> map, int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return -1;
    }
}