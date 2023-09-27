package algorithmStudy;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int idx = 0;
        
        for(int i=2; i<=a; i++){
            if(i==2 || i==4 || i==6 || i==8 || i==9 || i==11)
                idx += 31;
            else if(i==5 || i==7 || i==10 || i==12)
                idx += 30;
            else
                idx += 29;
        }
        
        return day[(idx + b) % 7];
    }
}
