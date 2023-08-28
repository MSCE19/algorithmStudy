import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        ArrayList<Integer> weight = new ArrayList<>(Arrays.asList(Arrays.stream(people).boxed().toArray(Integer[]::new)));
        ArrayList<Integer> availablePeople = new ArrayList<>();
        weight.removeIf(n -> n > limit - 40);
        answer += people.length - weight.size();
        Collections.sort(weight);
        
        for(int i = 0 ; i < weight.size() ; i++){
            int tmp = weight.get(i);
            availablePeople = weight.stream()
                .filter(n -> n <= limit - tmp)
                .collect(Collectors.toCollection(ArrayList::new));
            Collections.sort(availablePeople, Collections.reverseOrder());
            availablePeople.remove(Integer.valueOf(tmp)); // 딱 limit의 반인 경우 본인도 리스트에 들어가서 그 경우 빼주기
            
            for(int j = 0 ; j < availablePeople.size() ; j++){
                if(tmp + availablePeople.get(j) <= 100){
                    weight.remove(availablePeople.get(j));
                    weight.remove(i);
                    answer++;
                    i--;
                    break;
                }
            }
        }
        answer += weight.size();
        
        return answer;
    }
}