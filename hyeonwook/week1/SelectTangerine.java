package prgmrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SelectTangerine {
    public static int solution(int k , int[] tangerine){
        int answer= 0;
        int sum= 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < tangerine.length; i++) {            //해시맵에 키: 귤 크기, 값: 개수 저장
            if (map.get(tangerine[i]) == null){
                map.put(tangerine[i],1);
            }else{
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }
        }
        for (Integer value : map.values()) {                    //값들을 Arraylist에 저장
            array.add(value);
        }
        Collections.sort(array,Collections.reverseOrder());     //내림차순 정렬

        for (int i = 0; i < array.size(); i++) {                //sum에 더하면서 k의 값(판매 수) 을 넘으면 종료 후 리턴
            if(sum<k){
                sum += array.get(i);
                answer +=1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int []tan ={1,3,2,5,4,5,2,3};
        System.out.println(solution(4,tan));
    }
}
