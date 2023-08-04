package PS.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words= {"tank", "tick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        solution(n, words);
        //2
    }
    public static int[]solution(int n , String[] words){
        int [] answer= new int[2];
        int turn = 0;
        String before="";
        ArrayDeque<String> stk = new ArrayDeque<>();
        ArrayDeque<String> dup = new ArrayDeque<>();
        for (int i = 0; i < words.length; i++) {
            stk.addLast(words[i]);
        }
        //스택 비면 종료
        while(!stk.isEmpty()){
            //턴 증가
            turn+=1;
            //실행 인원은 N명
            for (int i = 1; i <=n ; i++) {
                //첫 번째 턴일 경우, before 가 없기 때문에 before 설정
                if(before.equals("")) {
                    before = stk.pollFirst();
                    dup.add(before);
                    continue;
                }

                String tmp = stk.pollFirst();
                //중복이거나, 단어의 끝과 단어의 앞이 같지 않다면 게임 종료
                if(tmp!=null&&(before.charAt(before.length()-1)!=tmp.charAt(0))||dup.contains(tmp)){
                    System.out.println("거침");
                    answer[0]= i;
                    answer[1]= turn;
                    return answer;
                }
                //아니라면 현재값이 before가 됨
                before =tmp;
                if(before!=null) dup.add(before);

            }

        }
        return answer;
    }
}
