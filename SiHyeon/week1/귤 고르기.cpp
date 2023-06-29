#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool cmp(pair<int, int>& a, pair<int, int>& b)
{
    return a.second > b.second;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    map<int, int> sizeCount;
    for (auto v : tangerine) //사이즈별로 갯수를 센다
        sizeCount[v]++;
    vector<pair<int, int>> sortCount(sizeCount.begin(), sizeCount.end());
    sort(sortCount.begin(), sortCount.end(), cmp); //value의 내림차순으로 정렬
    int index = 0;
    while (k > 0)
    {
        k -= sortCount[index++].second;
        answer++;
    }
    return answer;
}