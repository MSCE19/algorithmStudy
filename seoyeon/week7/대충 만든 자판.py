def solution(keymap, targets):
    answer = []
    keytable = {}
    for i in keymap :
        for idx, j in enumerate(i) :
            if j in keytable :
                keytable[j] = min(keytable[j], idx+1)
            else :
                keytable[j] = idx+1
    for i in targets :
        tmp = 0
        for j in i :
            if j not in keytable:
                tmp = -1
                break
            tmp += keytable[j]
        answer.append(tmp)
    return answer

# https://blog.naver.com/rabbii11/223182609503