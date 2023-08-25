from math import gcd

def solution(arr):
    def cal(a, b) :
        return a*b // gcd(a,b)
    while 1 :
        arr.append(cal(arr.pop(), arr.pop()))
        if len(arr) == 1 :
            return arr[0]