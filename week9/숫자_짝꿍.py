""" 9주차 두 번째 <숫자 짝꿍> """

def solution(X, Y):
    bf = []
    
    for i in X :
        for j in Y :
            if i == j :
                bf.append(i) # bf에 짝꿍수 삽입
                X = X.replace(i, '', 1) # i를 공백으로 1번 변경
                Y = Y.replace(j, '', 1) # j를 공백으로 1번 변경
    
    set_bf = set(bf) # 중복값을 처리하기 위해 정리
    
    if not set_bf : # 짝꿍이 없을 경우 -1 반환
        return "-1"
    elif  set_bf == {'0'} : # 중복값을 제거한 짝꿍값이 0이면 0을 반환
        return "0"

    bf.sort(reverse=True) # 내림차순 정렬해서 제일 큰 수 만들기
    
    return ''.join(bf) # 리스트를 문자열로 바꿈


                                ↓↓↓↓↓

def solution(X, Y):
    answer = ''
    
    
    for i in sorted(set(X) & set(Y), reverse = True): # X와 Y의 교집합만 내림차순 정렬
        answer += str(i) * min(X.count(i), Y.count(i)) # X와 Y에서 교집합되는 수만 찾아서 answer에 추가
        
    """     ex. X와 Y의 교집합이 9, 7, 5, 2, 1 일 때, 
            X에 있는 9가 9개, Y에 있는 9가 7개라면
            결국 겹치는 값은 7개인 거니까 9를 answer에 7번 추가 
                                  → 7, 5, 2, 1 또한 반복    """
    
    if answer:
        if set(answer) == {'0'}: # 짝꿍이 0으로만 구성된 경우 0을 반환
            return '0'
        else: 
            return answer
    else: # 짝꿍이 없는 경우
        return '-1'