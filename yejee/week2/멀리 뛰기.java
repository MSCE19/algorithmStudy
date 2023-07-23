class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n + 1]; //배열의 크기가 1인 경우 7번줄의 실행을 위해 +1
        
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i = 2 ; i < n ; i++){ //피보나치
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }
        
        answer = arr[n - 1];
        
        return answer;
    }
}