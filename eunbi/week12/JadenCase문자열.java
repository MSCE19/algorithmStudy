package algorithmStudy;

import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charS = s.toCharArray();
        
        if(charS[0] <= 122 && charS[0] >= 97)
            charS[0] -= 32;
        
        for(int i=0; i<charS.length-1; i++){
            if(charS[i+1] >= 65 && charS[i+1] <= 90)
                charS[i+1] += 32;
            if(charS[i] == ' ' && charS[i+1] <= 122 && charS[i+1] >= 97)
                charS[i+1] -= 32;
        }

        return String.valueOf(charS);
    }
}
