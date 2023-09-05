#include <string>
#include <vector>
#include <set>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    multiset<string> participants; //연관 컨테이너인 set을 활용한다.
    for (auto p : participant)
        participants.insert(p);
    for (auto c : completion)
    {
        auto iter = participants.find(c);
        if (iter != participants.end()) //탐색에 성공하면 지워줌
            participants.erase(iter);
    }
    for (auto p : participants)
        answer += p;
    return answer;
}