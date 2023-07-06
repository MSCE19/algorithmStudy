package prgmrs;

import java.util.*;

public class failureRate {
        static public int[] solution(int N, int[] stages) {
            int[] check = new int[N];
            double[] rate = new double[N];
            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < stages.length; j++) {
                    if (stages[j] == i + 1) {
                        check[i]++;
                    }
                }
            }
            //실패율 구하는 부분
            int player = stages.length; //도달한 플레이어 수
            for (int i = 0; i < check.length; i++) {
                int num = check[i];
                if (player == 0) {
                    rate[i] = 0;
                } else {
                    rate[i] = (double) num / player;
                }
                player -= check[i];     //연산에 사용한 플레이어 수만큼 차감
            }
            double max = 0;
            int target = 1;
            for (int i = 0; i < rate.length; i++) {     //answer 담아서 출력
                max = rate[0];
                target = 1;
                for (int j = 0; j < rate.length; j++) {
                    if (rate[j] > max) {
                        max = rate[j];
                        target = j + 1;
                    }
                }
                rate[target - 1] = -1;
                answer[i] = target;
            }
            return answer;
        }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] s = solution(N,stages);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
