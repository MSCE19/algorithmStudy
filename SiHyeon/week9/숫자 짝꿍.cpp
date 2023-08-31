#include <string>
#include <vector>
#include <set>

using namespace std;

string solution(string X, string Y)
{
    string answer = "";
    multiset<char> MySet; // 빠른 탐색을 위한 set
    multiset<char> Result;
    for (auto c : X)
        MySet.insert(c);
    for (auto c : Y)
    {
        auto iter = MySet.find(c);
        if (iter != MySet.end()) // 있다는 뜻
        {
            MySet.erase(iter); // 지우고
            Result.insert(c);  // 결과에 추가
        }
    }
    if (Result.empty())
        answer = "-1";
    else
    {
        if (Result.size() == Result.count('0')) //'0'만 있으면 0으로 처리
            answer = "0";
        else
            for (auto i = Result.rbegin(); i != Result.rend(); i++) // 오름차순이니까 역으로 순회
                answer.push_back(*i);
    }
    return answer;
}