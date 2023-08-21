package PS.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class 신규아이디추천 {
    static String new_id;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new_id = br.readLine();


        UpperToLowerChar();
        RemoveIncompatibleChar();
        ChangeContinuousPoint();
        RemoveFrontAndLastPoint();
        ReplaceEmptySpace();
        RemoveExceedChar();
        AddCharUntil3();
        System.out.println(new_id);
    }


    public static void UpperToLowerChar() {
        new_id = new_id.toLowerCase();
    }

    public static void RemoveIncompatibleChar() {
        StringBuilder removed = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char now = new_id.charAt(i);
            if (now == '~' || now == '!' || now == '@' || now == '#' || now == '$' || now == '%' || now == '^' || now == '&' || now == '*' ||
                    now == '(' || now == ')' || now == '=' || now == '+' || now == '[' ||
                    now == '{' || now == ']' || now == '}' || now == ':' || now == '?' || now == ',' || now == '<'
                    || now == '>' || now == '/') {
                continue;
            }
            removed.append(now);
        }
        new_id = removed.toString();
    }

    public static void ChangeContinuousPoint() {
        StringBuilder changed=new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            if(i==0){
                changed.append(new_id.charAt(i));
            }
            else if((new_id.charAt(i) =='.' && new_id.charAt(i-1) =='.')){
                continue;
            }
            else {
                changed.append(new_id.charAt(i));
            }
        }
        new_id = changed.toString();
    }

    public static void RemoveFrontAndLastPoint() {
        if(new_id.length()==1&&new_id.charAt(0)=='.'){
            new_id=new_id.replace('.',' ');
            return;
        }
         if(new_id.charAt(0)=='.'){
           new_id=new_id.substring(1);
           new_id = new_id;
        }
        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
    }

    public static void ReplaceEmptySpace() {
        new_id=new_id.replace(" ","a");
    }

    public static void RemoveExceedChar() {
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.'){
                new_id=new_id.substring(0,new_id.length()-1);
            }
        }
    }

    public static void AddCharUntil3() {
        if(new_id.length()<=2){
            char last = new_id.charAt(new_id.length()-1);
            for (int i = new_id.length(); i <3 ; i++) {
                new_id+=last;
            }
        }
    }
}
/*1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/