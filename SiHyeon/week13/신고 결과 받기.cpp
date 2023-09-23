#include <string>
#include <vector>
#include <set>
#include <unordered_map>
#include <map>
#include <algorithm>
#include <sstream>

using namespace std;

vector<string> split(string input, char delimiter)
{
    vector<string> result;
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, delimiter))
    {
        result.push_back(temp);
    }

    return result;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k)
{
    vector<int> answer;
    set<string> report_set;
    map<string, int> reportCount;             // key가 신고받은 횟수
    unordered_map<string, int> id_map;        // key가 메일 받을 횟수
    map<string, vector<string>> reportTarget; // key = 신고 당한사람, value = 신고 한사람
    for (auto r : report)                     // 중복없는 신고 리스트 생성
    {
        report_set.insert(r);
    }
    for (auto id : id_list) // 메일 받을 횟수 초기화
    {
        id_map.insert(make_pair(id, 0));
        answer.push_back(0);
    }
    for (auto r : report_set)
    {
        // 중복 없는 신고 리스트에서 신고 당한 사람과 신고한 사람 정리
        vector<string> log = split(r, ' ');
        reportTarget[log[1]].push_back(log[0]); // key = 신고 당한사람
    }
    // 신고한 사람의 count가 k이상이면 신호한 사람 매일 횟수 +1
    for (auto r : reportTarget)
    {
        if (r.second.size() >= k)
        {
            for (auto id : r.second)
                id_map[id]++;
        }
    }
    for (auto id : id_map) // id.first = 이름, id.second = 이메일 받는 횟수
    {
        // 주어진 id_list의 순서로 answer에 이메일 횟수를 넣어줌
        int index = find(id_list.begin(), id_list.end(), id.first) - id_list.begin();
        answer[index] = id.second;
    }
    return answer;
}