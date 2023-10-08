def solution(a, b):
    li = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    last = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    month = a - 1
    count = sum(last[:month])-1
    return li[(count + b) % 7]