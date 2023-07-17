#include <string>
#include <cmath>
#include <vector>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int index = 0;
    vector<int> score;
    while (index < dartResult.size() - 1)
    {
        int value = dartResult[index++] - '0';
        if (dartResult[index] == '0') //다음에 0이 오면 10 // 맘에 안드는 방법이지만..
        {
            value = 10;
            index++;
        }
        char bonus = dartResult[index++];
        int point = 0;
        //보너스 계산
        if (bonus == 'S')
            point = value;
        else if (bonus == 'D')
            point = pow(value, 2);
        else
            point = pow(value, 3);
        //옵션계산
        if (dartResult[index] == '*')
        {
            point *= 2;
            if (!score.empty()) //벡터가 있으면 이전 점수에도 옵션을 반영
                score[score.size() - 1] *= 2;
            index++;
        }
        else if (dartResult[index] == '#')
        {
            point *= -1;
            index++;
        }
        score.push_back(point);
    }
    for (auto v : score)
        answer += v;
    return answer;
}