import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        String[] keymapByIndex = new String[100];   // 키맵의 인덱스별 문자들을 모아 만든 문자열 배열
        int keymapIndex = 0;                        // 위의 문자열 배열의 인덱스 
        int number = 0;                             // 버튼 눌러야 하는 횟수
        
        StringBuilder sameIndexString = new StringBuilder();
        
        Arrays.fill(keymapByIndex, "");
        Arrays.fill(answer, 0);
        
        for(int i = 0; i < targets.length ; i++){                   // 타깃 하나 
            for(int j = 0 ; j < targets[i].length() ; j++){         // i번째 타깃의 j번째 index
                number = -1;
                for(int k = 0 ; k < targets[i].length() ; k++){     // keymap의 세로 인덱스
                    
                    if(k > keymapIndex){
                        for(int l = 0 ; l < keymap.length ; l++){           // keymap의 인덱스
                            sameIndexString.append(keymap[l].charAt(keymapIndex));
                        }
                        keymapByIndex[k] = String.valueOf(sameIndexString);
                        keymapIndex++;
                        sameIndexString.setLength(0); //초기화
                    }
                    if( keymapByIndex[k].contains(Character.toString(targets[i].charAt(j))) ){
                        number = j+1; 
                        break;
                    }
                }
                if(number != -1)
                    answer[i] += number;
                else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
} 