package algorithmStudy;

import java.util.*;

class Solution {
    String answer = "";
    int[][] arr = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2, 0}, {2,1}, {2,2}};
    int[] R = {3,2};
    int[] L = {3,0};
    
    public String solution(int[] numbers, String hand) {
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]%3 == 2 || numbers[i] == 0){ // 2, 5, 8, 0
                if(distance(R, arr[numbers[i]]) > distance(L, arr[numbers[i]]))
                    touch(numbers[i], "L");
                
                else if(distance(R, arr[numbers[i]]) < distance(L, arr[numbers[i]]))
                    touch(numbers[i], "R");
                
                else{
                    if(hand.equals("right"))
                        touch(numbers[i], "R");
                    else
                        touch(numbers[i], "L");
                }
            }
            else if(numbers[i]%3 == 1)  // 1, 4, 7
                touch(numbers[i], "L");
            else                        // 3, 6, 9
                touch(numbers[i], "R");
        }
        return answer;  
    }
    public void touch(int a, String str){
        if(str.equals("R")){
            R = arr[a];
            answer += "R";
        }
        else{
            L = arr[a];
            answer += "L";
        }
    }
    public int distance(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
