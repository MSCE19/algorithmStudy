#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes)
{
    int answer = 1;
    map<string, int> MyMap;
    vector<int> AllCombination;
    for (auto c : clothes) // map으로 정리
    {
        MyMap[c[1]]++;
    }
    for (auto &type : MyMap)
    {
        // 한 의상종류에서 1개입는경우 + 안입는 경우 -> 안입는 조합을 구하는 이유는 다른 옷을 입으면 안입어도 될때가 있기때문
        AllCombination.push_back(type.second + 1);
        // 모든 타입별로 입을 곱하면 모든 경우의 수
    }
    for (auto c : AllCombination)
    {
        answer *= c;
    }
    answer--; // 모두 안입는경우 제외
    return answer;
}