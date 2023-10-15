package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>(Arrays.asList(report)); // �ߺ� �Ű� ����
        String[] d_report = set.toArray(new String[0]); // �ߺ� �Ű� ������ ����Ʈ �迭
        Map<String, Integer> map = new HashMap<String, Integer>(); // �Ű���� Ƚ�� �����ϴ� ��
        Map<String, Integer> email = new HashMap<String, Integer>(); // ���� �̸��� ��
        List<String> list = new ArrayList<>(); // ���� ���� ������ ����Ʈ
        
        for(int i=0; i<d_report.length; i++)
            map.put(d_report[i].split(" ")[1], map.getOrDefault(d_report[i].split(" ")[1], 0) + 1); // �Ű� Ƚ�� ����
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) // ����Ʈ�� ���� ���� ����
            if(entry.getValue()>=k)
               list.add(entry.getKey());

        for(int i=0; i<d_report.length; i++) // �̸��� ���� ������ �ʿ� ����
            if(list.contains(d_report[i].split(" ")[1]))
                email.put(d_report[i].split(" ")[0], email.getOrDefault(d_report[i].split(" ")[0], 0) + 1);
        
                
        for(int i=0; i<id_list.length; i++)  // �������� ���� ��� ���� �� ����
            if(email.containsKey(id_list[i]))
                answer[i] = email.get(id_list[i]);

        return answer;
    }
}