#include <string>
#include <vector>

using namespace std;

int solution(string s)
{
    int answer = s.length();
    vector<char> MyStack;
    int length = s.length();
    for (int i = 0; i < length; i++) // 탐색할 시작 위치
    {
        for (int move = 0; move < length; move++) // 위치부터 탐색시작
        {
            int c = s[(i + move) % length];
            // 열린 괄호는 스택에 추가
            // 닫힌 괄호는 스택 맨위와 비교
            // 괄호 완성이면 제거 하고 반복
            // 괄호 실패면 실패 -> 끝
            // 열린 괄호만 들어오면 실패처리
            if (c == '{' || c == '[' || c == '(')
                MyStack.push_back(c);
            else if (!MyStack.empty() && (c - MyStack.back() == 1 || c - MyStack.back() == 2)) // 아스키 값이 괄호 열림과 닫힘이 1 또는 2 차이나기 때문
                MyStack.pop_back();
            else
            {
                MyStack.clear();
                answer--;
                break;
            }
        }
        if (!MyStack.empty()) // 열린 괄호만 남으면
            answer--;
        MyStack.clear();
    }
    return answer;
}