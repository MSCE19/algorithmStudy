#include <string>
#include <vector>
#include <set>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    multiset<string> participants; //���� �����̳��� set�� Ȱ���Ѵ�.
    for (auto p : participant)
        participants.insert(p);
    for (auto c : completion)
    {
        auto iter = participants.find(c);
        if (iter != participants.end()) //Ž���� �����ϸ� ������
            participants.erase(iter);
    }
    for (auto p : participants)
        answer += p;
    return answer;
}