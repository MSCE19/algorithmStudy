def solution(dartResult):
    answer = 0
    spc = ''
    # 분리작업
    for i in dartResult :
        if i != '#' and i != '*' and i != 'S' and i != 'D' and i != 'T' :
            spc += i
        else : 
            spc += i
            spc += ' '
    tmp = spc.split(' ')
    tmp = tmp[:-1]
    # S, D, T 적용
    for i in range(len(tmp)) :
        if tmp[i][-1] == 'S' : 
            tmp[i] = int(tmp[i][:-1]) ** 1
        elif tmp[i][-1] == 'D' :
            tmp[i] = int(tmp[i][:-1]) ** 2
        elif tmp[i][-1] == 'T' :
            tmp[i] = int(tmp[i][:-1]) ** 3
    # *과 #처리
    for i in range(len(tmp)) :
        if tmp[i] == '*' :
            if tmp.index(tmp[i]) == 1 :
                tmp[i-1] *= 2
            else :
                if tmp[i-2] != '#' and tmp[i-2] != '*' and tmp[i-2] != ' ':
                    tmp[i-2] *= 2
                else :
                    tmp[i-3] *= 2
                tmp[i-1] *= 2
            tmp[i] = ' '
        elif tmp[i] == '#' :
            tmp[i-1] *= -1
            tmp[i] = ' '
    # 합 구하기
    for i in tmp :
        if type(i) == int :
            answer += i
    return answer