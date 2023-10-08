def solution(want, number, discount):
    answer = 0
    wants = []
    for i in range(len(want)) :     # list
        for j in range(number[i]) :
            wants.append(want[i])
    for idx in range(len(discount)-9) :
        discount_check = discount[idx:idx+10]   # copy
        if sorted(discount_check) == sorted(wants) :
            answer += 1    
    return answer