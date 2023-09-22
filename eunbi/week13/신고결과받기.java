package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>(Arrays.asList(report)); // 중복 신고 제거
        String[] d_report = set.toArray(new String[0]); // 중복 신고 제거한 레포트 배열
        Map<String, Integer> map = new HashMap<String, Integer>(); // 신고당한 횟수 저장하는 맵
        Map<String, Integer> email = new HashMap<String, Integer>(); // 받은 이메일 수
        List<String> list = new ArrayList<>(); // 정지 유저 저장할 리스트
        
        for(int i=0; i<d_report.length; i++)
            map.put(d_report[i].split(" ")[1], map.getOrDefault(d_report[i].split(" ")[1], 0) + 1); // 신고 횟수 저장
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) // 리스트에 정지 유저 저장
            if(entry.getValue()>=k)
               list.add(entry.getKey());

        for(int i=0; i<d_report.length; i++) // 이메일 받을 유저를 맵에 담음
            if(list.contains(d_report[i].split(" ")[1]))
                email.put(d_report[i].split(" ")[0], email.getOrDefault(d_report[i].split(" ")[0], 0) + 1);
        
                
        for(int i=0; i<id_list.length; i++)  // 유저별로 받은 결과 메일 수 저장
            if(email.containsKey(id_list[i]))
                answer[i] = email.get(id_list[i]);

        return answer;
    }
}