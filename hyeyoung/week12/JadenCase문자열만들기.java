class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();    
        String first = s.charAt(0) + "";
        sb.append(first.toUpperCase());
        
        for(int i = 1; i < s.length(); i++){
            String now = s.charAt(i) + "";
            if(now.equals(' ')) sb.append(" ");
            else if(s.charAt(i - 1) == ' ') sb.append(now.toUpperCase());
            else sb.append(now.toLowerCase());
        }
        
        answer = sb.toString();
        return answer;
    }
}
