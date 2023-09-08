def solution(food):
    answer = ''
    stack = []
    repeat = 0
    for i in range(1, len(food)) :
        if food[i] % 2 != 0 : 
            food[i] -= 1
        if food[i] % 2 == 0 :
            repeat = food[i] // 2
            while(repeat > 0) :
                answer += str(i)
                repeat -= 1
    answer += '0'
    stack = answer[:-1]
    for i in range(1, len(stack) + 1) :
        answer += stack[-i]
    return answer