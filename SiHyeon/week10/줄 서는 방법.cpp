#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long getFactorial(long long n)
{
    if (n == 1)
        return n;
    return n * getFactorial(n - 1);
}

vector<int> solution(int n, long long k)
{
    vector<int> answer;
    vector<int> arr;
    for (int i = 1; i <= n; i++)
    {
        arr.push_back(i);
    }
    // 순열 n개의 수에서 n개를 뽑는것 -> n!가지
    // k번째 조합을 구하기 위해선 첫째자리는 반올림(k / (n-1)!) - 1 -> 첫째자리 인덱스
    // k = k % (n-1)!, 배열에서 제거, n=n-1하고 다시 위 과정 반복
    while (n > 1)
    {
        long long fac = getFactorial(n - 1); // 자리의 수가 같은 반복의 단위 6이면 6마다 인덱스가 증가
        int index = ceil((double)k / fac) - 1;
        k = k % fac;          // 나머지는 첫째자리를 선정하고 둘째자리가 몇번째 위치한 것인지 확인 즉 1~fac까지
        k = k == 0 ? fac : k; // 예외처리 0이면 둘째자리가 제일 마지막 번째라는 뜻 하지만 0이 나오므로 fac으로 처리
        answer.push_back(arr[index]);
        arr.erase(arr.begin() + index);
        n--;
    }
    answer.push_back(arr[0]); // 마지막 남은거 추가.
    return answer;
}