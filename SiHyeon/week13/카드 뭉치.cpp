#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal)
{
    for (auto g : goal) // goal을 순회
    {
        // 두 카드덱의 front를 확인하면서 완성 가능한지 확인
        if (cards1.front() == g)
        {
            cards1.erase(cards1.begin());
        }
        else if (cards2.front() == g)
        {
            cards2.erase(cards2.begin());
        }
        else
            return "No";
    }
    return "Yes";
}