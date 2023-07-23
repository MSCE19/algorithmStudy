package PS.kakao;

import java.util.HashMap;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(solution("23four5six7"));
    }
    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== 'z'){
                sb.append(0);
                i+=3;
            }
            else if(s.charAt(i)=='o'){
                sb.append(1);
                i+=2;
            }
            else if(s.charAt(i)=='t'){
                if(i+1 < s.length()){
                if(s.charAt(i+1)=='w' ){
                    sb.append(2);
                    i+=2;
                }else{
                    sb.append(3);
                    i+=4;
                }}
            }
            else if(s.charAt(i)=='f'){
                if(s.charAt(i+1)=='o' && i+1 < s.length()){
                    sb.append(4);
                    i+=3;
                }else{
                    sb.append(5);
                    i+=3;
                }
            }
            else if (s.charAt(i) == 's') {
                if(s.charAt(i+1)=='i' && i+1 < s.length()){
                    sb.append(6);
                    i+=2;
                }else{
                    sb.append(7);
                    i+=4;
                }
            }
            else if(s.charAt(i)=='e'){
                sb.append(8);
                i+=4;
            }
            else if (s.charAt(i) == 'n') {
                sb.append(9);
                i+=3;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
