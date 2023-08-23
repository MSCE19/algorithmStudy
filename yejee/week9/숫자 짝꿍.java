class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int xCnt = 0 , yCnt = 0;
        
        for(int i = 9 ; i >= 0 ; i--){
            xCnt = X.length() - X.replace(String.valueOf(i),"").length();
            yCnt = Y.length() - Y.replace(String.valueOf(i),"").length();
            
            for(int j = 0 ; j < Math.min(xCnt, yCnt) ; j++){
                if(i == 0 && answer.length() == 0){ 
                    answer.append("0");
                    break;
                }
                answer.append(i);
            }
        }
        if(answer.length() == 0)
            answer.append("-1");
        
        return answer.toString();
    }
}