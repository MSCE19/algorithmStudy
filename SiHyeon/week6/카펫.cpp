#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    vector<int> divisor;
    //Yellow의 약수 구하기, 제곱근까지만 구해서 절반만 구함 -> yellow의 가로 세로 후보
    for (int i = 1; i <= sqrt(yellow); i++)
    {
        if (yellow % i == 0)
            divisor.push_back(i);
    }

    //brown = 2x + 2y + 4, yellow = xy
    //y = yellow/x, 2x + (2*yellow)/x = brown - 4
    for (int i = 0; i < divisor.size(); i++)
    {
        if (2 * divisor[i] + (2 * yellow) / divisor[i] == brown - 4)
        {
            answer.push_back(yellow / divisor[i] + 2);
            answer.push_back(divisor[i] + 2);
            break;
        }
    }
    return answer;
}