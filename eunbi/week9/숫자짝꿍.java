import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Character, Integer> xMap = new HashMap<Character, Integer>();
        Map<Character, Integer> yMap = new HashMap<Character, Integer>();
                
        for(int i=0; i<X.length(); i++)
            xMap.put(X.charAt(i), xMap.getOrDefault(X.charAt(i), 0)+1);
         
        for(int i=0; i<Y.length(); i++)
            yMap.put(Y.charAt(i), yMap.getOrDefault(Y.charAt(i), 0)+1);
        
        for(Map.Entry<Character, Integer> x : xMap.entrySet()){
            if(yMap.containsKey(x.getKey())){// y와 x에 같은 값이 있는경우
                int min = Math.min(x.getValue(), yMap.get(x.getKey())); // 더 적은 개수를 저장
                answer += String.valueOf(x.getKey()).repeat(min);
            }
        }
        
        if(answer == "")
            answer = "1-";
        if(answer.charAt(answer.length()-1)=='0')
            answer = "0";
        
        String reversed = new StringBuffer(answer).reverse().toString();
        return reversed; 
    }
}