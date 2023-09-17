def solution(food):
    answer, left = '', []
    food[0] = 2
    
    for i in range(len(food)):
        for j in range(food[i]//2):
            if int(food[i]) // 2 == 0:
                pass
            else:
                left.append(str(i))
    
    left = left[1:]
    answer = ''.join(left) + '0' + ''.join(left[::-1])
    
    return answer