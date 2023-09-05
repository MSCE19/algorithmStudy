import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        String str=s;
        
        for(int i=0;i<s.length();i++){
            char temp = str.charAt(0);
            str = str.substring(1) + temp;
            if(checkString(str)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean checkString (String str){
        Stack<Character> s = new Stack<>();
        
        char[] arr = str.toCharArray();
        
        for(char data:arr){
            if(s.isEmpty()){
                s.push(data);
            }
            else if(s.peek()=='['&&data==']'){
                s.pop();
            }
            else if(s.peek()=='('&&data==')'){
                s.pop();
            }
            else if(s.peek()=='{'&&data=='}'){
                s.pop();
            }
            else{
                s.push(data);
            }
        }
        
        if(s.isEmpty()){
            return true;
        }
        
        return false;
    }
}
