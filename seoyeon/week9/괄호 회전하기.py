def check(tmp) :
    stack = []
    for i in tmp :
        if len(stack) > 0 :
            if stack[-1] == '(' and i == ')' :
                stack.pop()
            elif stack[-1] == '{' and i == '}' :
                stack.pop()
            elif stack[-1] == '[' and i == ']' :
                stack.pop()
            else : stack.append(i)
        else : stack.append(i)
    if len(stack) == 0 :
        return 1
    else :
        return 0

def solution(s):
    answer = 0
    for i in range(len(s)) :
        if check(s):            # 체킹함수 실행 시 짝이 맞으면
            answer += 1         # answer 값 증가
        s = s[1:] + s[:1]       # 회전
    return answer