#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> types;
    char s_type[] = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
    for (auto s : s_type) //초기화
        types.insert(pair<char, int>(s, 0));
    for (int i = 0; i < survey.size(); i++)
    {
        if (choices[i] >= 4) //점수 확인해서 4점 이상이면 뒤에 타입에 점수 추가
            types[survey[i].at(1)] += choices[i] % 4;
        else
            types[survey[i].at(0)] += 4 - (choices[i] % 4);
    }
    for (int i = 0; i < 8; i += 2)
    {
        //타입별 점수 비교 후 큰 타입 선택
        answer += types[s_type[i]] >= types[s_type[i + 1]] ? s_type[i] : s_type[i + 1];
    }
    return answer;
}