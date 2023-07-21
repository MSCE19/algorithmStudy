package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++)
            s = s.replaceAll(number[i], Integer.toString(i));

        return Integer.parseInt(s);
    }
}