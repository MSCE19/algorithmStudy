#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    vector<int> newLost;
    //여분 체육복을 도난 당한경우 미리 여분 체육복에서 제거
    for (int i = 0; i < lost.size(); i++)
    {
        auto index = find(reserve.begin(), reserve.end(), lost[i]);
        if (index != reserve.end())
        {
            reserve.erase(index);
            answer++;
        }
        else
            newLost.push_back(lost[i]); //도난당한 리스트를 갱신
    }
    //도난 당한 사람 앞뒤로 빌려줄 수 있는지 확인
    for (auto l : newLost)
    {
        auto index = find(reserve.begin(), reserve.end(), l - 1);
        if (index != reserve.end())
        {
            reserve.erase(index);
            answer++;
        }
        else
        {
            index = find(reserve.begin(), reserve.end(), l + 1);
            if (index != reserve.end())
            {
                reserve.erase(index);
                answer++;
            }

        }
    }
    return answer;
}