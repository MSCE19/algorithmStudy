package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int max = people.length - 1;
        int min = 0;
       
        Arrays.sort(people);
        
        while(min <= max){
            if(people[min] + people[max] <= limit){
                min++;
                max--;
                answer++;
            }
            else{
                max--;
                answer++;
            }
        }
        
        return answer;
    }
}