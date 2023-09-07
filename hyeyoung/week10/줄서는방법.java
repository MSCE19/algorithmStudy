import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        long fac = 1;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            fac *= i;
            list.add(i);
        }

        //idx는 0부터 시작하기 때문에 맞춰주기 위해서 --
        k--;

        while (n > 0) {
            // 각 자리에 자리에 들어갈 경우의 수
            fac /= n;
            // 자리 숫자 결정
            int val = (int) (k / fac);
            answer[idx] = list.get(val);
            list.remove(val);
            
            // 다음 자리수를 구하기 위해 k값 재할당
            k %= fac;
            idx++;
            n--;
        }
        return answer;
    }
}
