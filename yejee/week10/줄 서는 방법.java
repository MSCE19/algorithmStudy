import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long order = 0;
        long factorialNumber = 1;
        
        ArrayList<Integer> peopleNum = new ArrayList<>();
        
        for(int i = 1 ; i <= n ; i++){
            peopleNum.add(i);
        }
        
        for(int i = 0 ; i < n ; i++){
            order = 0;
            factorialNumber = factorial(n-1 -i);
            while(k > factorialNumber){
                k -= factorialNumber;
                order++;
            }
            
            answer[i] = peopleNum.get(Long.valueOf(order).intValue());
            peopleNum.remove(Long.valueOf(order).intValue());
        }
        return answer;
    }
    public long factorial(long n){
        long factorialNumber = 1;
        for(; n > 0 ; n--){
            factorialNumber *= n;
        }
        return factorialNumber;
    }
}