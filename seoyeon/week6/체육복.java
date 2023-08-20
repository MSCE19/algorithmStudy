import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0; // 총 몇 명의 학생
        int have = 0;   // 여벌 옷 갖고 있어서 참여 가능한 학생
        int count = 0;  // 받아서 참여 가능한 학생
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여벌옷을 가지고 있던 학생이 도난당한 경우, 참여는 할 수 있지만 못 빌려줌 이제
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {   // lost안에 여벌옷 친구가 들어있으면
                    have += 1;  // 일단 참여는 가능
                    lost[i] = -1; // 잃어버린 학생 -1해주고
                    reserve[j] = -1; // 이제 더이상 여분이 없으니까
                    break;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                // 인접한 사람에게만 빌려줄 수 있게
                // 여기를 고치면 될 거 같은데 모르겠어여.. 반대로도 시도해봄
                if(lost[i]==reserve[j]+1  || lost[i]==reserve[j]-1) {
                    count++;
                    reserve[j] = -100;  // 이제 못빌려주게 만든다..이게 맞을까
                    break;
                }
            }
        }
        // 전체 학생 수 - 잃어버린 학생 수 + 여벌옷 있었는데 도난당한 + 받은
        answer = n - lost.length + have + count;
        return answer;
    }
}

// 2학년 시절 코테 스터디 할 때 자바로 풀었던 기록이 있어서 올려봅니다 ㅎ
// 주석 다 달아놓은거 웃기당