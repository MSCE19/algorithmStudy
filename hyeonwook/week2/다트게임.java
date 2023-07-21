package prgmrs;

import java.io.IOException;

public class 다트게임 {
    public static int solution(String dartResult) {
        int answer = 0;
        int [] score = new int[3];
        int index=0;
        String str = "";
        char [] dart = new char[dartResult.length()];
        for (int i = 0; i < dartResult.length(); i++) {
            dart[i] = dartResult.charAt(i);
        }
        for (int i = 0; i < dart.length; i++) {

            if(dart[i]>='0' && dart[i]<='9'){
                str += String.valueOf(dartResult.charAt(i));

            }
            else if(dart[i]=='S' ||dart[i]=='D'||dart[i]=='T' ){
                int num = Integer.parseInt(str);
                if(dart[i]=='S'){
                    score[index++]+= (int)Math.pow(num,1) ;
                }
                else if(dart[i]=='D'){
                    score[index++]+= (int)Math.pow(num,2);
                }
                else if(dart[i]=='T'){
                    score[index++]+= (int)Math.pow(num,3);
                }
                str ="";
            } else {
                if(dart[i]=='*'){
                    score[index-1]*=2;
                    if(index-2>=0) score[index-2]*=2;
                }
                else {
                    score[index-1]*=(-1);
                }
            }
        }
            answer= score[0]+score[1]+score[2];

        return answer;
    }
    public static void main(String[] args) throws IOException {

        System.out.println(solution("1S*2T*3S"));


    }
}
