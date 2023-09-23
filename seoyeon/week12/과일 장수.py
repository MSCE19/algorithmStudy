def solution(k, m, score):
    tmp = []       # 각 상자의 최소 점수
    count = len(score) // m  # 몇 상자
    score.sort(reverse = True)  # 정렬
    i = 1
    while count :
        if i > len(score) :
            break
        else :
            idx = m * i
            tmp.append(score[idx-1])
        count -= 1
        i += 1
    return sum(tmp) * m