#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount)
{
    int answer = 0;
    // count(시작, 시작+10, 찾는 원소)로 계산
    for (int day = 0; day <= discount.size() - 10; day++)
    {
        int match = 0; // 살 수 있는 want의 수
        for (int i = 0; i < want.size(); i++)
        {
            if (count(discount.begin() + day, discount.begin() + day + 10, want[i]) >= number[i])
            {
                match++;
            }
            else
                break;
        }
        if (match == want.size()) // want한 모든걸 살수있다면
        {
            answer++;
        }
    }
    return answer;
}