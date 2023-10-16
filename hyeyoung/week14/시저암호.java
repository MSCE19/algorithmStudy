import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == ' ') answer += " ";
            else{
                if (c >= 'a' && c <= 'z'){
                    c = (char)(c + n);
                    if(c > 'z') c -= 26;
                }else if( c >= 'A' && c <= 'Z'){
                    c = (char)(c+n);
                    if(c > 'Z') c-= 26;
                }
                answer += c;
            }
        }
        return answer;
    }
}
