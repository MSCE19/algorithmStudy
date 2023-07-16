package algorithmStudy;

import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>(); // 결과 값을 담음

    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length]; // 방문한 인덱스인지 확인
        
        dfs(visit, 0, dungeons, k, 0);
        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

        return list.get(0); // 맨 앞값이 가장 많이 던전을 방문할 수 있는 횟수
    }
    public void dfs(boolean[] visit, int index, int[][] dungeons, int k, int ans){        
        if(index == dungeons.length){
            list.add(ans);
            return ;
        }
        for(int i=0; i<dungeons.length; i++){
            if(visit[i] == false){
                if(k >= dungeons[i][0]){ //필요 피로도 조건 충족 시
                    visit[i] = true;  // 방문 표시
                    dfs(visit, index+1, dungeons, k - dungeons[i][1], ans+1); // 재귀호출
                    visit[i] = false; // 원래상태로 돌림
                }
                else
                    dfs(visit, index+1, dungeons, k, ans);//필요 피로도 조건 충족 못했을 때의 재귀 호출
            }
        }
    }
}

