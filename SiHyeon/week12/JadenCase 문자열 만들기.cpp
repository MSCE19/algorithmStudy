#include <string>
#include <vector>

using namespace std;

string solution(string s)
{
    string answer = "";
    answer += toupper(s[0]); // 첫글자 대문자
    for (int i = 1; i < s.size(); i++)
    {
        // char c = tolower(s[i]);
        // if (s[i-1] == ' ')
        //     c = toupper(s[i]);
        // answer += c;
        answer += s[i - 1] == ' ' ? toupper(s[i]) : tolower(s[i]);
    }
    return answer;
}