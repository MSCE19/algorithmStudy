import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        //언제나 completion이 한 명 짧으니까
        for(i = 0; i < completion.length; i++){
            // 없는 사람을 찾아서 바로 return
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}

// blog posting : loding..