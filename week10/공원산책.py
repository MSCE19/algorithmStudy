def solution(park, routes):
    dog, block = [], []
    H, W = len(park), len(park[0])  # park의 높이와 넓이

    # 로봇 강아지와 장애물의 초기 위치 설정
    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                dog = [i, j]  # 강쥐의 위치 저장
            elif park[i][j] == 'X':
                block.append([i, j])  # 장애물의 위치 저장

    # routes에 따라 강쥐 이동
    for route in routes:
        direction, distance = route.split()  # 입력 문자열을 분리하여 방향과 거리 추출
        distance = int(distance)  # 거리를 정수로 변환
        x, y = dog  # 현재 강쥐의 위치

        if direction == 'E':
            new_y = y + distance
            if new_y < W:
                # 이동할 위치가 장애물이 아닌지 확인
                if all([x, j] not in block for j in range(y + 1, new_y + 1)):
                    y = new_y
            else:
                continue  # 공원을 벗어난 경우 명령 무시
        elif direction == 'S':
            new_x = x + distance
            if new_x < H:
                # 이동할 위치가 장애물이 아닌지 확인
                if all([i, y] not in block for i in range(x + 1, new_x + 1)):
                    x = new_x
            else:
                continue  # 공원을 벗어난 경우 명령 무시
        elif direction == 'N':
            new_x = x - distance
            if new_x >= 0:
                # 이동할 위치가 장애물이 아닌지 확인
                if all([i, y] not in block for i in range(new_x, x)):
                    x = new_x
            else:
                continue  # 공원을 벗어난 경우 명령 무시
        elif direction == 'W':
            new_y = y - distance
            if new_y >= 0:
                # 이동할 위치가 장애물이 아닌지 확인
                if all([x, j] not in block for j in range(new_y, y)):
                    y = new_y
            else:
                continue  # 공원을 벗어난 경우 명령 무시

        dog = [x, y]  # 강아지의 위치 업데이트

    return dog
