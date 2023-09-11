package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyMinMap = new HashMap<Character, Integer>();
        
        for(String i : keymap)
            for(int j=0; j<i.length(); j++) // �ּ� Ű �� ����
                keyMinMap.put(i.charAt(j), Math.min(keyMinMap.getOrDefault(i.charAt(j), j+1), j+1));
                
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                if(keyMinMap.containsKey(targets[i].charAt(j))) // �ּ� Ű ���� ���Ǿ� �ִ� ���
                    answer[i] += keyMinMap.get(targets[i].charAt(j));
                else{ // ���� ���� ���� ���
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
