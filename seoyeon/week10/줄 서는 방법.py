import math

def solution(n, k):
    answer = []
    tmp = [i for i in range(1, n+1)]
    k -= 1
    while tmp :
        idx = k // math.factorial(n-1)
        answer.append(tmp[idx])
        del tmp[idx]
        k = k % math.factorial(n-1)
        n -= 1
    return answer