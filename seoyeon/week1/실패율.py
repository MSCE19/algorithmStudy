def solution(N, stages):
    answer = []
    tmp = []
    a = len(stages)
    for i in range(1, N+1) :
        cnt = 0
        if i in stages :
            cnt = stages.count(i)
            tmp.append(cnt/a)
        else : 
            tmp.append(0)
        a -= cnt
    answer = sorted(range(len(tmp)), key=lambda k: tmp[k], reverse=True)
    for i in range(len(answer)) :
        answer[i] += 1
    return answer