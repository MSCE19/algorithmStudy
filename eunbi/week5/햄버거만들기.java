package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(int[] ing) {
        int answer = 0;        
        List<Integer> list = new ArrayList<Integer>();
        for(int i : ing)
            list.add(i);
        
        for(int i=0; i<list.size()-3; i++){
            if(list.get(i)==1 && list.get(i+1)==2 && list.get(i+2)==3 && list.get(i+3)==1){
                answer++;
                for(int j=0; j<4; j++)
                    list.remove(i);
                if(i<=2)    
                    i=-1;  // 0번 인덱스부터 다시 체크
                else
                    i=i-4; // 현 위치로부터 세칸 전부터 체크 ex) 1231234이고 i=3일 때
            }
        }
       
        return answer;
    }
}