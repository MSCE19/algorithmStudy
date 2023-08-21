def solution(wallpaper):
    answer = []
    tmp1 = []
    tmp2 = []
    for i in range(len(wallpaper)) :
        for j in range(len(wallpaper[i])) :
            if wallpaper[i][j] == '#' :
                tmp1.append(i)
                tmp2.append(j)
    answer.append(min(tmp1))
    answer.append(min(tmp2))
    answer.append(max(tmp1)+1)
    answer.append(max(tmp2)+1)
    return answer