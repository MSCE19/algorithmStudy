#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool desc(int a, int b)
{
    return a > b;
}
vector<int> solution(int k, vector<int> score)
{
    vector<int> answer;
    vector<int> sortlist;
    for (auto s : score)
    {
        if (sortlist.size() < k)
            sortlist.push_back(s);
        else if (sortlist.back() < s)
        {
            sortlist.pop_back();
            sortlist.push_back(s);
        }
        sort(sortlist.begin(), sortlist.end(), desc); // 내림차순 정렬
        answer.push_back(sortlist.back());
    }
    return answer;
}