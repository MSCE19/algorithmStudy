def solution(name, yearning, photo):
    answer = []
    for i in photo :
        score = 0
        for j in range(len(i)) :
            if i[j] in name :
                score += yearning[name.index(i[j])]
        answer.append(score)
    return answer