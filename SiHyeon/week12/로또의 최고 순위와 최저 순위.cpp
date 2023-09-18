#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums)
{
    vector<int> answer = {0, 0};
    // 0이 아닌 값과 로또 점수를 비교
    // 모든 0이 맞으면 최고 순위
    // 모든 0이 틀리면 최저 순위
    int match = 0; // 맞는 갯수
    for (auto num : lottos)
    {
        if (find(win_nums.begin(), win_nums.end(), num) != win_nums.end())
        {
            match++;
        }
    }
    answer[1] = (6 - match) >= 5 ? 6 : 6 - match + 1; // 1,0개 맞으면 6등처리
    match += count(lottos.begin(), lottos.end(), 0);  // 0이 다 맞는 경우
    answer[0] = (6 - match) >= 5 ? 6 : 6 - match + 1;
    return answer;
}