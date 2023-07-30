def solution(n, words):
    answer = [0, 0]
    tmp = []
    use = []
    for i in range(0, len(words)-1) :
        tmp.append(words[i])
        tmp.append(words[i+1])
        if (tmp[0][-1] != tmp[1][0]) or tmp[1] in use :
            answer = [(i+1)%n+1, (i+1)//n+1]
            break
        use.append(tmp[0])
        tmp.clear()
    return answer