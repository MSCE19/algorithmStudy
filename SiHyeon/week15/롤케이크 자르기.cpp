#include <string>
#include <vector>
#include <set>
#include <map>

using namespace std;

int solution(vector<int> topping)
{
    int answer = 0;
    // map에 토핑 종류와 갯수를 저장
    // topping의 순서대로 map에서 갯수를 빼줌
    // 빼준 종류의 수와 map에서 0이 아닌 종류의 수가 같으면 같은 분배
    // 빼준 종류의 수는 set으로 계산
    map<int, int> rollCake;
    for (auto t : topping)
        rollCake[t]++;
    set<int> takeSet;
    for (int i = 0; i < topping.size(); i++)
    {
        takeSet.insert(topping[i]); // 철수가 가져가고
        rollCake[topping[i]]--;     // 토핑 갯수 감소
        if (rollCake[topping[i]] == 0)
            rollCake.erase(rollCake.find(topping[i]));

        if (rollCake.size() == takeSet.size())
            answer++;
    }
    return answer;
}