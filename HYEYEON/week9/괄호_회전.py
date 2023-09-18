""" 9주차 첫 번째 <괄호 회전하기> """

def solution(s):
    answer = 0
    
    if len(s) % 2 == 1 : # 홀수면 짝 안 맞으니까 바로 0을 return
        return answer
        
    for i in range(len(s)) :
        brks = s # 일단 s를 복사한 brks을 가지고 올바른 문자열이 있으면 제거
        
        while True:
            
            if brks[0] == ')' or brks[0] == '}' or brks[0] == ']': # 얘네가 첫번째면 바로 빠져나가서 회전
                break
            
            if '()' in brks or '[]' in brks or '{}' in brks: # 올바른 문자열 제거하기
                brks = brks.replace('()', '').replace('[]', '').replace('{}', '')
            
                if len(brks) == 0 : # 문자열 없으면 1 더하고 빠져나가서 회전하기
                    answer += 1
                    break
                
            elif len(brks) != 0 : # 올바른 문자열이 아니라 제거되지 않은 경우도 빠져나가서 회전하기
                break
        
        s = s[1:] + s[0] # 회전시키기
         
    return answer