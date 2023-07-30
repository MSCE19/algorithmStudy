def solution(today, terms, privacies):
    today = list(map(int, today.split('.'))) # [0]연, [1]월, [2]일
    terms = {i[0]: int(i[2:])for i in terms}
    
    # 일 단위로 통합하기
    today = today[0] * 28 * 12 + today[1] * 28 + today[2] 
    
    answer = []
    for i, pri in enumerate(privacies):
        day, kind = pri.split()
        month = terms[kind]
        day = list(map(int, day.split('.')))
        day = day[0] * 28 * 12 + day[1] * 28 + day[2]-1 + month * 28 # 일 단위로 통합
        
        if day < today:
            answer.append(i+1)
                    
    return answer