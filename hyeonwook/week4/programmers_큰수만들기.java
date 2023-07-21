package PS.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class programmers_큰수만들기 {
    public static void main(String[] args) {
        solution("1231234", 3);
    }
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int []arr  = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i)-'0';
        }
        int start = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int max = 0;
            for (int j = start; j <= i+k; j++) {
                if(max<arr[j]){
                    max=arr[j];
                    start=j+ 1;
                }
            }

            sb.append(max);

        }

        return sb.toString();
    }
}
