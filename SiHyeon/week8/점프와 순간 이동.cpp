#include <iostream>
using namespace std;

int solution(int n)
{
    int ans = 0;

    // 문제가 원하는 것은 결국 n을 2로 계속나누고
    // 홀수면 -1을 진행 후 계속 나눠서 0으로 만들때 홀수가 나타나는 횟수를 물어보는 것임.

    while (n > 0)
    {
        if (n % 2 != 0) // 홀수
        {
            n--;
            ans++;
        }
        else // 짝수
        {
            n /= 2;
        }
    }

    return ans;
}