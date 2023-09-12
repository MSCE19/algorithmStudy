import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        ArrayList<Integer> prime = new ArrayList<>();
        Map<Integer, Integer> answerDivisor = new HashMap<>();
        int divisorCnt = 0;
        int nonDivisible = 0;
        
        // 소수 목록 구하기 
        for(int i = 2 ; i < 100 ; i++){
            nonDivisible = 0;
            for(int num : prime){
                if(i % num == 0){
                    break;
                }
                else
                    nonDivisible++;
            }
            if(nonDivisible == prime.size())
                prime.add(i);
        }        
        
        for(int dividend : arr){
            for(int divisor : prime){
                divisorCnt = 0;
                while(dividend % divisor == 0){
                    divisorCnt++;
                    dividend /= divisor;
                }
                if(answerDivisor.containsKey(divisor))
                    divisorCnt = Math.max(divisorCnt, answerDivisor.get(divisor));
                answerDivisor.put(divisor, divisorCnt);
            }
        }
        
        for(int i : answerDivisor.keySet()){
            answer *= Math.pow(i, answerDivisor.get(i));
        }
        
        return answer;
    }
}