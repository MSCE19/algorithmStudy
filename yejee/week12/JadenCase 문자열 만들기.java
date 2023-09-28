class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        answer.append(s.substring(0,1).toUpperCase());
        
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ')
                answer.append(" ");
            else if(s.charAt(i-1) == ' ')
                answer.append(s.substring(i,i+1).toUpperCase());
            else
                answer.append(s.substring(i,i+1).toLowerCase());
        }
        return answer.toString();
    }
}