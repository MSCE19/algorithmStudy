package PS.greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {50,70,80};
        int limit = 100;
        solution(people,limit);
    }
    public static int solution(int[] people, int limit){
        boolean[] saved = new boolean[people.length];
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            dq.addLast(people[i]);
        }
        while(!dq.isEmpty()){
            int first = dq.getFirst();
            int last = dq.getLast();
            int sum = first + last;
            if (sum > limit){
                dq.pollLast();
                answer+=1;
            }else if(sum <= limit){
                dq.pollFirst();
                dq.pollLast();
                answer+=1;
            }
        }

        System.out.println("answer = " + answer);
        return answer;

    }



    }


