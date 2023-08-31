package prgmrs;

import java.util.*;
import java.util.stream.Collectors;

public class 숫자짝궁 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "100";
        System.out.println(solution(X, Y));
    }

    private static String solution(String X, String Y) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < X.length(); i++) {
            char now = X.charAt(i);
            if(map.get(now)!=null){
                map.put(now, map.get(now)+1);
            }else{
                map.put(now,1);
            }


        }
        for (int i = 0; i < Y.length(); i++) {
            char now = Y.charAt(i);
            if(map.get(now)==null) {
                continue;
            }

            if(map.get(now)>0){
                arr.add(now);
                map.put(now,map.get(now)-1);
            }
        }
        Collections.sort(arr,((o1, o2) -> {return o2-o1;}));
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        String result = sb.toString();
        if(result.isEmpty()) return "-1";
        if(result.replace("0","").isEmpty()) return "0";
        return result;
    }
}
