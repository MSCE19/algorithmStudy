def solution(lottos, win_nums):
    answer = []
    dup = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    cnt = lottos.count(0)
    correct = 0
    for i in lottos :
        if i in win_nums :
            correct += 1
    answer.append(dup.get(correct+cnt))
    answer.append(dup.get(correct))
    return answer