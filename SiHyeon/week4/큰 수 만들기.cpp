#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    for (int i = 1; i < number.size() && k > 0; i++) //k값이 0보다 크고 number를 끝까지 돌기 전까지 순회한다
    {
        if (number[i - 1] < number[i])
        {
            number.erase(i - 1, 1);
            i = 0;
            k--;
        }
    }
    answer = number.erase(number.size() - k, k); //다 돌아도 k값이 남은 경우는 끝에서 빼준다
    return answer;
}