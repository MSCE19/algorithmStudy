def solution(n, lost, reserve):
    answer = n
    reserve.sort()
    tmp = []
    for i in reserve :  # 여분 갖고 온 학생이 잃어버렸을 경우
        if i in lost :
            lost.remove(i)      # lost에서 없애주고
        else :
            tmp.append(i)       # reserve에서도 없애서 tmp 리스트에 담아주기
    for i in tmp :              # tmp 리스트에서
        if i-1 in lost :        # 앞사람 빌려주기
            lost.remove(i-1)
        elif i+1 in lost :      # 뒷사람 빌려주기
            lost.remove(i+1)
    answer -= len(lost)         # 전체 학생에서 결국 못 빌린 학생 수 빼기
    return answer