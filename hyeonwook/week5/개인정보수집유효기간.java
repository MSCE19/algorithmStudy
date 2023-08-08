package PS.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String today = "2020.12.17";
        String[] terms = {"A 12"};
        String[] pv = {"2010.01.01 A", "2019.12.17 A"};
        solution(today, terms, pv);
    }

    public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        //현재 년도, 달 , 날짜
        int td_yr = Integer.parseInt(today.substring(2, 4));
        int td_mm = Integer.parseInt(today.substring(5, 7));
        int td_dd = Integer.parseInt(today.substring(8, 10));

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        //타입 별로 해시맵 삽입
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }
        //현재 인덱스의 년도, 달, 날짜 분리
        for (int i = 0; i < privacies.length; i++) {
            int yr = Integer.parseInt(privacies[i].substring(2, 4));
            int mm = Integer.parseInt(privacies[i].substring(5, 7));
            int dd = Integer.parseInt(privacies[i].substring(8, 10));
            int tmp = mm;
            String type = privacies[i].split(" ")[1];
            mm += map.get(type);
            if (mm > 12) {
                yr += mm / 12;
                mm %= 12;
                if (mm == 0) {
                    mm = 12;
                    yr -= 1;
                }
            }
            if (yr > td_yr || (yr >= td_yr && mm > td_mm) || (yr >= td_yr && mm >= td_mm && dd > td_dd)) continue;
            arr.add(i + 1);
            //3가지 경우가 있다. privacies의 년도가 더 클 경우, 년도는 같은데 달이 더 클 경우, 년도와 달이 같은데, 날이 더 클 경우
        }
        System.out.println(arr);
        return arr;
    }
}

