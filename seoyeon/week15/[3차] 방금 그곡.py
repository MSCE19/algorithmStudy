def replace(m):
    for a,b in zip(["A#", "C#", "D#", "F#", "G#"], ["T","U","I","O","P"]):
        m = m.replace(a,b)
    return m
def solution(m, musicinfos):
    answers = []
    musics = {}
    musicinfos = list(map(lambda x: list(x.split(",")), musicinfos))
    for x in musicinfos:
        runtime = (int(x[1].split(":")[0]) - int(x[0].split(":")[0]))*60 + int(x[1].split(":")[1]) - int(x[0].split(":")[1])
        x[3] = replace(x[3])
        musics[x[3]*(runtime//len(x[3]))+x[3][:runtime%len(x[3])]] = (runtime, x[2])
    for music in musics:
        if replace(m) in music:
            answers.append(musics[music])
    answers.sort(key = lambda x:x[0], reverse = True)
    return not answers and "(None)" or answers[0][1]