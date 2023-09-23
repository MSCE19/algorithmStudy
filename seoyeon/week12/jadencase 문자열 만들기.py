def solution(s):
    answer = ''
    tmp = s.lower()
    idx = 0
    for i in tmp :
        if idx == 0 :
            answer += i.upper()
        else :
            answer += i
        idx += 1
        if i == ' ' :
            idx = 0
    return answer