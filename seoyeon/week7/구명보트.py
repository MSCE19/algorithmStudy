from collections import deque
def solution(people, limit):
    answer = 0
    people = deque(sorted(people))
    while people :
        if len(people) == 1 :
            answer += 1
            break
        if people[0] + people[-1] <= limit :
            people.pop()
            people.popleft()
        else : 
            people.pop()
        answer += 1
    return answer