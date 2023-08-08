import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> ingredients = new ArrayList<>(Arrays.asList(Arrays.stream(ingredient).boxed().toArray(Integer[]::new)));
        String hamburger = "";
        
        for(int i = 0 ; i < ingredients.size() - 3 ; i++){
            for(int j = i ; j < i + 4 && j < ingredients.size(); j++){
                hamburger += ingredients.get(j);
            }
            if(hamburger.equals("1231")){
                for(int j = i ; j < i + 4 ; j++){
                    ingredients.remove(i);
                }
                i = i >= 3 ? i - 4 : -1;
                answer++;
            }
            hamburger = "";
        }
        return answer;
    }
}