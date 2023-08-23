class Solution {
    String paren = "({[)}]";
    public int solution(String s) {
        int answer = 0;        
        
        for(int i = 0; i < s.length() ; i++){
            if(strCheck(s))
                answer++;
            s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
    public boolean strCheck(String s){
        
        int parenNum, i;
        
        if(s.length() % 2 == 1)
            return false;
        if(s.replace("(", "").length() != s.replace(")","").length())
            return false;
        if(s.replace("{", "").length() != s.replace("}","").length())
            return false;
        if(s.replace("[", "").length() != s.replace("]","").length())
            return false;
        
        // 첫문자가 ({[ 중 하나인지 확인
        for(parenNum = 0 ; parenNum < 3 ; parenNum++){
            if(s.charAt(0) == paren.charAt(parenNum)){
                break;
            }
        }
        // 아니면 false 반환
        if(parenNum ==  3)
            return false;
        
        // 두번째 문자부터 첫문자에 상응하는 문자를 찾는다. 
        for(i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == paren.charAt(parenNum+3)){
                if(i ==1)
                    break;
                if(i % 2 == 1 && strCheck(s.substring(1, i)))
                    break;
            }
        }
        
        if(i == s.length())
            return false;
        //상응하는 문자가 마지막 문자가 아니라면 그 뒷부분이 올바른 문자열인지 확인
        if(i != s.length() -1 && strCheck(s.substring(i+1)) == false)
            return false; 
        
        return true;
        
    }
}