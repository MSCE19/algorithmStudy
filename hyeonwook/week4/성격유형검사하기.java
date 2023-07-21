package PS.kakao;

import javax.swing.text.html.Option;
import java.util.*;

public class 성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        StringBuilder sb= new StringBuilder();
        char[]type= {'R','T','C','F','J','M','A','N'};
        //점수 저장
        HashMap<Integer,Integer> scoreMap =  new HashMap<>();
        scoreMap.put(1,3);
        scoreMap.put(2,2);
        scoreMap.put(3,1);
        scoreMap.put(5,1);
        scoreMap.put(6,2);
        scoreMap.put(7,3);

        //typemap 에다 type 도 저장
        HashMap<Character,Integer> typeMap = new HashMap<>();
        for (int i = 0; i < type.length; i++) {
            typeMap.put(type[i],0);
        }

        char [][]tp = new char[choices.length][2];
        //2차원 배열로 만들어야 됨
        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < 2; j++) {
                tp[i][j] = survey[i].charAt(j);
            }
        }
        //번호 따라 앞에 요소에 추가할건지, 뒤에 요소에 추가할건지 결정
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            if(choice>4){
                typeMap.put(tp[i][1], typeMap.get(tp[i][1])+scoreMap.get(choice));
            }
            else{
                typeMap.put(tp[i][0],typeMap.get(tp[i][0])+scoreMap.get(choice));
            }
        }

        //값 비교하면서 큰 값 저장
        if(typeMap.get('R')>=typeMap.get('T')){
            sb.append('R');
        } else if (typeMap.get('R')<typeMap.get('T')) {
            sb.append('T');
        }
        if(typeMap.get('C')>=typeMap.get('F')){
            sb.append('C');
        } else if (typeMap.get('C')<typeMap.get('F')) {
            sb.append('F');
        }
        if(typeMap.get('J')>=typeMap.get('M')){
            sb.append('J');
        } else if (typeMap.get('J')<typeMap.get('M')) {
            sb.append('M');
        }
        if(typeMap.get('A')>=typeMap.get('N')){
            sb.append('A');
        } else if (typeMap.get('A')<typeMap.get('N')) {
            sb.append('N');
        }
        System.out.println(sb);
        String res = sb.toString();
        return res;
    }
    public static void main(String[] args) {
        String[] survey = {"TR", "FC", "MJ", "AN"};
        int [] choices = {2,6,7,1};
        solution(survey,choices);
    }

}
