def solution(answers):
    answer = []
    temp1 = []
    omr = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]] 
    for i in range(len(omr)) : 
        if len(omr[i]) > len(answers):
            omr[i] = omr[i][:len(answers)]    
    for i in range(len(omr)) :
        if len(omr[i]) != len(answers) and len(omr[i]) < len(answers):
            omr[i] += omr[i] * (len(answers) // len(omr[i]))
            omr[i] += omr[i][:len(answers) % len(omr[i])]
    for i in range(len(omr)) :
        temp2 = 0
        for j in range(len(answers)):
            if answers[j] == omr[i][j] :
                temp2 += 1
        temp1.append(temp2)
    for i in range(len(temp1)) :
        if temp1[i] == max(temp1) :
            answer.append(i + 1)
    return answer