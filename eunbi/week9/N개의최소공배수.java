package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        answer = lcm(arr[0], arr[1]);
        
        for(int i=2; i<arr.length; i++)
            answer = lcm(answer, arr[i]);
            
        return answer;
    }
    
    public int lcm(int a, int b){
        int answer = 1;
                       
        for(int i=2; i<=Math.max(a, b); i++){
            while(a%i == 0 && b%i == 0){
                answer *= i;
                a /= i;
                b /= i;
            }
        }

        return answer*a*b;
    }
}

