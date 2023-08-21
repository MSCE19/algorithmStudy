def solution(new_id):
    answer = ''
    new_id = new_id.lower()     #1
    for i in new_id :           #2
        if i.islower() or i.isdigit() or i == '-' or i == '_' or i == '.' :
            answer += i
    while '..' in answer :      #3
        answer = answer.replace('..', '.')
    if answer[0] == '.' :       #4
        if len(answer) > 1 :
            answer = answer[1:]
        else : answer = '.'
    if answer[-1] == '.' :
        answer = answer[:-1]
    if len(answer) == 0 :       #5
        answer = 'a'
    if len(answer) > 15 :       #6
        answer = answer[:15]
        if answer[-1] == '.' :
            answer = answer[:-1]
    while len(answer) < 3 :     #7
        answer += answer[-1]
    return answer