def solution(k, m, score):
    answer = 0
    score.sort(reverse=True) # 내림차순 정렬 ex.[3,3,2,2,1,1], [4,4,4,4,4,4,2,2,2,2,1,1]
    score = score[(m-1)::m] # ex. [2], [4,4,2,1]
    
    for i in score :
        box = i * m
        answer += box
    
    return answer