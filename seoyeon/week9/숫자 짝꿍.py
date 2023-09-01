from collections import Counter

def solution(X, Y) :
    answer = ''
    cnt1 = Counter(X)
    cnt2 = Counter(Y)
    for i in range(9, -1, -1) :
        temp = min(cnt1[str(i)], cnt2[str(i)])
        answer += str(i) * temp
    if answer == '' :
        return '-1'
    if answer[0] == '0' :
        return '0'
    return answer
