def solution(k, score):
    HOF = []
    answer= []
    for s in score:
        HOF.append(s)
        if len(HOF) > k:
            HOF.remove(min(HOF))
        answer.append(min(HOF))
    return answer
