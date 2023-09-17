def solution(string):
    answer = ''
    string = string.lower() # 전부 소문자로 바꿔주기
    next = True
    
    """ 문자열을 읽어들인 뒤, 공백이 있을 경우 next=True로 변환,
        next=True면 s를 대문자로 바꿔주기"""
    
    for str in string :
        for s in str :
            if s == ' ' :
                answer += s
                next = True
            elif next == True :
                answer += s.upper() # 대문자로 바꿔준 뒤 next=False로 변환
                next = False
            else : # next=False인 경우는 그대로 문자열 추가
                answer += s
                
    return answer