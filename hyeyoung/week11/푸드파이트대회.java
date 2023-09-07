class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";
        for(int i = 1; i < food.length; i++){           
            for(int j = 0; j < food[i]/2 ; j++){
                answer += i;
            }                
        }
        StringBuilder sb = new StringBuilder(answer);
        reverse = sb.reverse().toString();
        answer = answer + 0 + reverse;
        
        return answer;
    }
}
