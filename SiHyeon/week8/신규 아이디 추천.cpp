#include <string>
#include <vector>
#include <regex>

using namespace std;

string solution(string new_id)
{
    // 1
    for (auto &c : new_id) // 주소로 접근해서 원본을 바꿔줌
        if (isalpha(c))
            c = tolower(c);

    // 2
    regex re_step2("[^a-z0-9-_.]");               // 가능한 문자를 제외한 문자를 찾기위한 regex
    new_id = regex_replace(new_id, re_step2, ""); // 불가능한 문자를 ""으로 변환

    // 3
    regex re_step3("\\.{2,}");                     // 점이 2개이상인 경우
    new_id = regex_replace(new_id, re_step3, "."); // 점 하나로 바꿔줌

    // 4
    if (new_id.front() == '.')
        new_id.erase(new_id.begin()); // 시작 점 제거
    if (new_id.back() == '.')
        new_id.pop_back(); // 끝 점 제거

    // 5
    if (new_id.empty())
        new_id = "a";

    // 6
    if (new_id.size() >= 16) // 16자 이상이면
        new_id.erase(15 + new_id.begin(), new_id.end());
    if (new_id.back() == '.')
        new_id.pop_back(); // 끝 점 제거

    // 7
    while (new_id.size() <= 2)
        new_id += new_id.back();

    return new_id;
}