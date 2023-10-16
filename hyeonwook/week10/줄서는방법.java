package prgmrs;

import java.util.*;

public class 줄서는방법 {

    public static void main(String[] args) {
        int n = 4;
        int k = 8;
        solution(n,k);

    }
    public static int[] solution(int n , int k ){
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        int []arr= new int[n];
        int []answer = new int[n];
        for (int i = 0; i <n ; i++) {
            list.add(i+1);
            factorial*=i+1;
        }
        k -=1;
        int idx = 0;
        while(idx < n){
             factorial = factorial / (n - idx);
             answer[idx++] = list.remove((int)(k/factorial));
             k %= factorial;
        }
        return answer;
    }

}
