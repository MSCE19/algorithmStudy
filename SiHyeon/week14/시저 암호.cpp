#include <string>
#include <vector>

using namespace std;

string solution(string s, int n)
{
    string answer = "";
    // s하나씩 n만큼 이동 후 answer에 저장
    // n이 동시 z Z를 넘어서는 경우 대문자 소문자 구분해서 처리
    for (auto c : s)
    {
        if (isalpha(c))
        {
            if (c + n > 'z' && islower(c)) // 소문자 z를 넘어가는 경우
                c = ('a' - 1) + (c + n - 'z');
            else if (c + n > 'Z' && isupper(c)) // 대문자 Z를 넘어가는 경우
                c = ('A' - 1) + (c + n - 'Z');
            else // 안넘어가는 경우
                c = c + n;
        }
        answer += c;
    }
    return answer;
}