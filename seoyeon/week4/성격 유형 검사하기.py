def solution(survey, choices):
    answer = ''
    dic = {'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    
    for i in range(len(choices)) :
        temp = ''
        if choices[i] < 4 :
            temp = survey[i][0]
            dic[temp] += 4-choices[i]
        else :
            temp = survey[i][1]
            dic[temp] += choices[i]-4
            
    if dic['R'] >= dic['T'] : answer += 'R' 
    else : answer += 'T'
    if dic['C'] >= dic['F'] : answer += 'C'
    else : answer += 'F'
    if dic['J'] >= dic['M'] : answer += 'J'
    else : answer += 'M'
    if dic['A'] >= dic['N'] : answer += 'A'
    else : answer += 'N'
    
    return answer