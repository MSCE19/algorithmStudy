package hyeyoung.week1;

import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args){
        Solution solutions = new Solution();

        String names[] = {"may", "kein", "kain", "radi"};
        int[] yearnings = {5, 10, 1, 3};
        String[][] photos = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"may", "kein", "brin", "deny"}};

        int[] result = solutions.solution(names, yearnings, photos);

        for (int score : result) {
            System.out.println("Score: " + score);
        }
    }

}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map1 = new HashMap<>();
        int[] answer = new int[photo.length];

        for(int i = 0; i < name.length; i++){
            map1.put(name[i], yearning[i]);
        }

        for(int i = 0 ; i < photo.length; i++){
            for(int j = 0; j < photo[i].length; j++){
                if(map1.containsKey(photo[i][j]))
                    answer[i] += map1.get(photo[i][j]);
            }
        }

        return answer;
    }
}