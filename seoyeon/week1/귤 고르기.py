def solution(k, tangerine):
    answer = 0
    tangerine.sort()
    tmp1 = {}
    for i in tangerine:
        if i in tmp1 :
            tmp1[i] += 1
        else : 
            tmp1[i] = 1
    tmp2 = sorted(tmp1.items(), key = lambda x:x[1], reverse = True)
    bucket = 0
    if tmp2[0][1] >= k : return 1
    else :
        for i in tmp2 :
            if bucket < k :
                bucket += i[1]   
                answer += 1 
    return answer