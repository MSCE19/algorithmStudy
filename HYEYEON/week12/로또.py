def solution(lottos, win_nums):
    answer = []
    low = 7
    zero = lottos.count(0)

    for win in win_nums :
        for lotto in lottos :
            if win == lotto :
                low -= 1
                
    high = low - zero
    answer.append(high)
    answer.append(low)
    
    if zero == 6 :
        answer = [1,6]
    elif zero == 0 and low == 7 :
        answer = [6,6]
        
    return answer