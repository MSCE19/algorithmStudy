package prgmrs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"AA"};
        String[] target = {"B"};

        solution(keymap, target);
    }

    public static int[] solution(String[] keymap, String[] target) {
        int[] answer = new int[target.length];
        int count = 0;
        //반복 돌면서 맵에다 키 값을 넣는다. 근데 최소값으로 넣어야된다.
        HashMap<Character, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if( !map.containsKey(now)){
                    map.put(now,i+1);
                }
                if(map.get(now)>i){
                    map.put(now,i+1);
                }
            }
        }

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length(); j++) {
                char now = target[i].charAt(j);
                if(!map.containsKey(now)){
                    count = -1;
                    break;
                }
                count+=map.get(now);
            }

            

            answer[i] = count;
            count=0;
        }
        return answer;
    }
}

