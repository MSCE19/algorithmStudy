import java.util.*;

class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
      
        int a = arr[0];
        int answer = 0;
      
        for(int i = 1; i < arr.length; i++){
            int b = arr[i];
            for(int j = a * b; j > 0; j--){
                if((j % a == 0) && (j % b == 0))
                    answer = j;
            }
            a = answer;
        }
      
        return answer;
    }
}
