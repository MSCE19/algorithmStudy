package algorithmStudy;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> l = new ArrayList<Integer>();
        List<Integer> r = new ArrayList<Integer>();
        
        for(int i : lost)
            l.add(i);
        for(int i : reserve)
            r.add(i);
        
        l.sort(Comparator.naturalOrder());
        r.sort(Comparator.naturalOrder());
        
        for(int i=0; i<r.size(); i++){
            if(l.contains(r.get(i))){ // 여벌 체육복이 있는데 도난 당한 경우
                    l.remove(l.indexOf(r.get(i)));
                    r.remove(i);
                    i--;
            }
        } // 이 경우를 먼저 계산해야함 (도난당한 학생은 빌려줄 수 없기 때문)
        
        for(int i=0; i<r.size(); i++){
            if(l.contains(r.get(i)-1)){ // 여분 학생의 앞 번호가 lost일 때
                l.remove(l.indexOf(r.get(i)-1));
                r.remove(i);
                i--; // list에서 제거했으므로 index를 이전으로 돌림
            }
            else if(l.contains(r.get(i)+1)){ // 여분 학생의 뒷 번호가 lost일 때
                l.remove(l.indexOf(r.get(i)+1));
                r.remove(i);
                i--;
            }
        }
        
        return n-l.size();
    }
}