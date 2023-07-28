class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10, right =12;
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == 0)
                numbers[i] = 11;
            if(numbers[i] % 3 == 1){
                answer += "L";
                left = numbers[i];
            }
            else if(numbers[i] % 3 == 0){
                answer += "R";
                right = numbers[i];
            }
            else{
                answer += LorR(left, right, numbers[i], hand);
                if(LorR(left, right, numbers[i], hand)=="L")
                    left = numbers[i];
                else
                    right = numbers[i];
            }
        }        
        return answer;
    }
    public String LorR(int left, int right, int next, String hand){
        int dis_l, dis_r;
        dis_l = (Math.abs(left - next) + 1) / 3;
        dis_r = (Math.abs(right - next) + 1) / 3;
        if((left-next) % 3 != 0)
            dis_l++;
        if((right-next) % 3 != 0)
            dis_r++;
        if(dis_l < dis_r){
            return "L";}
        else if(dis_l > dis_r){
            return "R";}
        else{ //양손의 거리가 같은 경우
            if(hand.equals("right"))
                return "R";
            else
                return "L";
        }
    }
    
}