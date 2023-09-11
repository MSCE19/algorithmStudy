class Solution {
    public int solution(String s) {
        int answer = 0;
        String temp = "";
        
        for(int i=0; i<s.length(); i++){
            s = s.substring(1, s.length()) + s.charAt(0);
            temp = s;
            
            while(temp.contains("()") || temp.contains("[]") || temp.contains("{}")){
                temp = temp.replace("()", "");
                temp = temp.replace("{}", "");
                temp = temp.replace("[]", "");
                
                if(temp==""){
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}