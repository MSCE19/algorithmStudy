package prgmrs;

import java.util.*;

public class test_exam {
    public static void main(String[] args) {
        int[] test = {1,3,2,4,2};
        solution(test);
    }
    public static int[] solution(int[] answers){
        ArrayList<Integer> array = new ArrayList<>();
        int[] answer;
        int[] first = {1,2,3,4,5};
        int[] sec = {2,1,2,3,2,4,2,5};
        int[] thr = {3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5};
        int[] dup ;
        int[] scr = {0,0,0};
        int max;


        for (int i = 0; i < answers.length; i++) {
            dup = new int[answers.length];
            dup[i] = first[i%5];
            if(dup[i] == answers[i]){
                scr[0]+=1;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            dup = new int[answers.length];
            dup[i] = sec[i%8];
            if(dup[i] == answers[i]){
                scr[1]+=1;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            dup = new int[answers.length];
            dup[i] = thr[i%thr.length];
            if(dup[i] == answers[i]){
                scr[2]+=1;
            }
        }
        max = Math.max(Math.max(scr[0],scr[1]),scr[2]);
        for (int i = 0; i < scr.length; i++) {
            if(max == scr[i]){
                array.add(i+1);
            }
        }
        answer=new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            answer[i]= array.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }
}
