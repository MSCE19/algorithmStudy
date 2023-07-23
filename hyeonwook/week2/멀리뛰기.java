package prgmrs;

public class 멀리뛰기 {
    public static void main(String[] args) {
        solution(8);
    }
    public static int solution(int n) {
        if(n == 1){
            return 1;
        }
        int[] memo = new int[n + 1];
        int answer = 0;
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n+1; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2])%1234567;
        }
        answer= memo[n];
        System.out.println(answer);

        return answer;
    }
}
