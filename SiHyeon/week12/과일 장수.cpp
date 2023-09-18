#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score)
{
    int answer = 0;
    sort(score.rbegin(), score.rend()); // 내림차순으로 정렬
    int index = 0;                      // 시작점 인덱스
    // m에 갯수에 맞는 비싼 과일끼리 먼저 포장
    while (score.size() >= index + m)
    {
        answer += score[index + m - 1] * m; // 최저 사과 점수 * 사과의 수
        // score.erase(score.begin(), score.begin() + m); //erase는 [n,m)이다. m미만임. -> 시간초과
        // 새로운 방법 지우지 말고 시작 인덱스를 이동시킴
        index += m;
    }
    return answer;
}