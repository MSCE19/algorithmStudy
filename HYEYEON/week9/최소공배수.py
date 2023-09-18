""" 9주차 세 번째 <N개의 최소공배수> """

def solution(arr): # 제일 마지막 숫자를 1-2-3 순서대로 곱하고 앞에 있는 배열들을 나눠보기
    num = 1
    
    while True : 
        cal_lcm = arr[-1] * num # 제일 큰 수를 1부터 곱한 값부터 앞의 수들을 나눠볼거임..
        success = True
        
        for i in range (len(arr)-1) : # 마지막은 안 나눠도 되니까 n-1번만 나눠보는거지 이제
            if cal_lcm % arr[i] != 0 : # 만약 나눠떨어지지 않으면
                success = False # 실패
                break # 앞에서 나눠떨어지지 않았으면 뒤는 볼 것도 없으니까 걍 빠져나가기
                
        num += 1
        
        if success == True : # 만약 성공이면 최소공배수 반환하기
            return cal_lcm