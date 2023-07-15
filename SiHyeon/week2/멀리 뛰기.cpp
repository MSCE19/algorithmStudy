#include <string>
#include <array>

using namespace std;
array<long long, 9999> memory = { 0, };

long long fibonacci(long long n) {
    long long result;
    if (n <= 1) return n;
    long long index = n;
    if (memory[index])
        return memory[index];
    else
        result = (memory[index] = fibonacci(n - 1) + fibonacci(n - 2));
    return result % 1234567;
}

long long solution(int n) {
    long long answer = fibonacci(n + 1);
    return answer % 1234567;
}