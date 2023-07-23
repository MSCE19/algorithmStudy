package hyeyoung.week3;

public class 피로도 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 10;
        int[][] dungeons = {
                {2, 5},
                {3, 7},
                {4, 10}
        };

        int result = solution.solution(k, dungeons);
        System.out.println("Max Count: " + result);
    }
}

class Solution {
    static boolean[] visited;
    static int max = 0;

    void explore(int piro, int[][] dungeons, int cnt) {
        // 모든 케이스 순회
        for (int i = 0; i < dungeons.length; i++) {
            int a = dungeons[i][0];
            int b = dungeons[i][1];

            // 기존에 방문 확인, 최소 피로도 확인
            if (visited[i] || piro < a) {
                continue;
            }

            // 방문
            visited[i] = true;
            explore(piro - b, dungeons, cnt + 1);
            // 다른 케이스를 위해 방문 취소
            visited[i] = false;
        }
        max = Math.max(max, cnt);
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        explore(k, dungeons, 0);
        return max;
    }
}
