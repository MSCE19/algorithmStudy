def solution(k, score):
    answer = [] # 최하위 점수 배열
    array = []
    for i in score :
        if len(array) < k :
            array.append(i)
        elif min(array) < i :
            array.remove(min(array))
            array.append(i)
        array.sort(reverse=True)
        m = array[-1]
        answer.append(m)
    return answer