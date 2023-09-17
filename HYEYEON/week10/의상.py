def solution(clothes):
    answer = 1 # 곱해야하니까 0 말고 1로 두기 !!!!
    category = []
    clothes_counts = {} # 옷의 종류와 개수 저장할 딕셔너리

    # category에서 옷의 이름은 제거하고 옷의 종류만 남기기
    for item in clothes:
        category.append(item[1])
    
    # 딕셔너리로 headgear = n, eyewear = m 과 같이 정리하고 확통처럼 계산
    # sort = 옷의 종류, count = 해당 종류 옷의 개수
    for sort in set(category) :
        count = category.count(sort)
        clothes_counts[sort] = count  # 딕셔너리에 의상 종류와 개수 저장하기
        answer *= (count + 1)  # 옷을 안 입는 경우도 존재하니 + 1

    answer -= 1 # 아무 것도 입지 않는 경우를 제외
    
    return answer