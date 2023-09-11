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
            if(l.contains(r.get(i))){ // ���� ü������ �ִµ� ���� ���� ���
                    l.remove(l.indexOf(r.get(i)));
                    r.remove(i);
                    i--;
            }
        } // �� ��츦 ���� ����ؾ��� (�������� �л��� ������ �� ���� ����)
        
        for(int i=0; i<r.size(); i++){
            if(l.contains(r.get(i)-1)){ // ���� �л��� �� ��ȣ�� lost�� ��
                l.remove(l.indexOf(r.get(i)-1));
                r.remove(i);
                i--; // list���� ���������Ƿ� index�� �������� ����
            }
            else if(l.contains(r.get(i)+1)){ // ���� �л��� �� ��ȣ�� lost�� ��
                l.remove(l.indexOf(r.get(i)+1));
                r.remove(i);
                i--;
            }
        }
        
        return n-l.size();
    }
}