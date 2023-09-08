def solution(park, routes):
    answer = []
    x1 = 0    # 강아지 start 위치 찾기
    y1 = 0
    for i in range(len(park)) :     # 행
        for j in range(len(park[i])) :  # 열
            if park[i][j] == 'S' :
                x1 = i
                y1 = j
                break
    for i in routes :       # move
        x2 = x1
        y2 = y1
        for j in range(int(i[2])) :     # 조건 확인 하며, 위치 setting
            if i[0] == 'E' and y2 != len(park[0])-1 and park[x2][y2+1] != 'X' :     # 동
                y2 += 1
                if j == int(i[2])-1 : 
                    y1 = y2
            elif i[0] == 'W' and y2 != 0 and park[x2][y2-1] != 'X' :        # 서
                y2 -= 1
                if j == int(i[2])-1 : 
                    y1 = y2
            elif i[0] == 'S' and x2 != len(park)-1 and park[x2+1][y2] != 'X' :  # 남
                x2 += 1
                if j == int(i[2])-1 : 
                    x1 = x2
            elif i[0] == 'N' and x2 != 0 and park[x2-1][y2] != 'X' :        # 북
                x2 -= 1
                if j == int(i[2])-1 : 
                    x1 = x2
    answer.append(x1)
    answer.append(y1)
    return answer