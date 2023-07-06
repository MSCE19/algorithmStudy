package prgmrs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class memoryScore {
    static public ArrayList solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer= new ArrayList<>(); //Arraylist 선언
        HashMap<String,Integer> map = new HashMap<>(); //Hashmap 선언
        for (int i = 0; i < name.length; i++) {
            map.put(name[i],yearning[i]); //Hashmap에 값들 대응해서 넣고
        }
        for (int i = 0; i < photo.length; i++) { //photo 배열 반복
            int sum =0 ;            //sum은 추억점수 더하는 변수
            for (int j = 0; j < photo[i].length ; j++) {
                if (map.containsKey(photo[i][j])){ //만약 Photo 배열의 요소가 Hashmap에 존재하면,
                    sum +=map.get(photo[i][j]);     // value를 가져와서 sum에 추가
                }
            }
            answer.add(sum);    //sum 값을 배열에 추가
        }
        return answer;
    }


    //Test
    public static void main(String[] args) {
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {{"kali", "mari", "don"},{"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        System.out.println(solution(name,yearning,photo));
}}