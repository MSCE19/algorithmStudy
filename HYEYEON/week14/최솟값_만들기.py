def solution(A, B):
    answer = 0
    A.sort(reverse=True)
    B.sort()
    
    answer = [a * b for a, b in zip(A, B)]
    answer = sum(answer)
    
    return answer
