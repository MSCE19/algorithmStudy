#include <string>
#include <vector>
#include <set>

using namespace std;

int getGcd(int num1, int num2)
{
    if (num2 == 0)
        return num1;
    else
        return getGcd(num2, num1 % num2);
}

int solution(vector<int> arr)
{
    int answer = 0;
    // 차례대로 두수의 최소공배수 구하고 다음수와 또 구하고 또 구하고
    while (arr.size() >= 2)
    {
        int num1 = arr.back();
        arr.pop_back();
        int num2 = arr.back();
        arr.pop_back();
        int gcd = getGcd(num1, num2);
        int lcm = num1 * num2 / gcd;
        arr.push_back(lcm);
    }
    answer = arr[0];
    return answer;
}