package prgmrs;

import java.util.HashMap;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println("solution(clothes) = " + solution(clothes));
    }
    public static int solution(String[][] clothes){
        int answer = 0;
        int times = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if(map.get(clothes[i][1]) == null){
                map.put(clothes[i][1],1);
            }
            else if(map.get(clothes[i][1])>0){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
        }

        for (String key : map.keySet()) {

            times *= map.get(key)+1;
        }
        answer+= times-1;

        return  answer;

    }
}
