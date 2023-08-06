package hyeyoung.week6;

import java.util.Arrays;

public class 체육복 {
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n];

        Arrays.fill(arr, 1);
        for(int i : lost)
            arr[i - 1] -= 1;
        for(int i : reserve)
            arr[i - 1] += 1;

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] == 0){
                if(i > 0 && arr[i - 1] == 2){
                    arr[i - 1]-=1;
                    arr[i]++;
                }
                else if(i < n - 1 && arr[i + 1] == 2){
                    arr[i + 1] -= 1;
                    arr[i]++;
                }
                else
                    answer --;
            }

        }
        return answer;
    }
}