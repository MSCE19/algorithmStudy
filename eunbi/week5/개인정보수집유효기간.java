package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[][] date = new int[privacies.length][3];
        int[] dday = {Integer.parseInt(today.substring(2, 4)), Integer.parseInt(today.substring(5, 7)), Integer.parseInt(today.substring(8, 10))}; // 오늘 날짜 정보
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(String i : terms) // key : 약관 종류, value : 유효기간
            map.put(i.charAt(0), Integer.parseInt(i.substring(2)));
        
        for(int i=0; i<privacies.length; i++){
            date[i][0] = Integer.parseInt(privacies[i].substring(2,4)); // 년
            date[i][1] = Integer.parseInt(privacies[i].substring(5,7)); // 월
            date[i][2] = Integer.parseInt(privacies[i].substring(8,10)); // 일
            if(date[i][1] + map.get(privacies[i].charAt(11)) > 12){ // 약관 유효기간을 더함
                date[i][0] = date[i][0] + (date[i][1] + map.get(privacies[i].charAt(11))) / 12;
                date[i][1] = (date[i][1] + map.get(privacies[i].charAt(11))) % 12;
                if(date[i][1] == 0){
                    date[i][0]--;
                    date[i][1] = 12;
                }
            }
            else
                date[i][1] = date[i][1] + map.get(privacies[i].charAt(11)); // 달만 더함
        }
        
        for(int i=0; i<date.length; i++){
            if(dday[0] > date[i][0]) // 년 비교. 오늘 년이 크면 파기
                list.add(i+1);
            else if(dday[0] == date[i][0]){ // 년 비교. 년이 같으면 월을 비교함
                if(dday[1] > date[i][1]) // 월 비교. 오늘 월이 크면 파기
                    list.add(i+1);
                else if(dday[1] == date[i][1]) // 월이 같다면
                    if(dday[2] >= date[i][2]) // 일 비교. 일이 같거나 크면 파기
                        list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
            
        return answer;
    }
}