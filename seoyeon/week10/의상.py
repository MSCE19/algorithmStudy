def solution(clothes):
    answer = 1
    dict = {}
    for i in clothes :
        if i[1] in dict.keys() :
            dict[i[1]] += 1
        else : dict[i[1]] = 1
    for i in dict :
        answer *= (dict[i] + 1)
    return answer - 1