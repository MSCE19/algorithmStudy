def solution(s, n):
    answer = ''
    
    for str in s :
        if str == ' ' :
            answer += str
        elif str in ('z', 'Z') :
            answer += chr(ord(str) - 26 + n)
        elif (ord(str) >= 65 and ord(str) <= 90 and ord(str) + n > 90) or (ord(str) >= 97 and ord(str) <= 122 and ord(str) + n > 122) :
                answer += chr(ord(str) - 26 + n)
        else : 
            answer += chr(ord(str) + n)
    
    return answer