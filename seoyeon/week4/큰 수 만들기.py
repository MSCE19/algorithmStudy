def solution(number, k):
    answer = ''
    stack = []
    a = 0
    for i in number :
        if len(stack) == 0 :
            stack.append(i)
            continue
        if k > 0 :
            while stack[-1] < i :
                stack.pop()
                k -= 1
                if len(stack) == 0 or k <= 0 :
                    break
        stack.append(i)
    if k > 0 :
        stack = stack[:-k]
    for i in stack :
        answer += str(i)
    return answer