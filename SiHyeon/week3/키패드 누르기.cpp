#include <string>
#include <vector>
#include <cmath>

using namespace std;

int getGap(int start, int end)
{
    int xGap = abs((start % 3 != 0 ? start / 3 : start / 3 - 1) - end / 3);
    int yGap = abs((start % 3 != 0 ? start % 3 - 1 : 2) - (end % 3 - 1));
    return xGap + yGap;
}

string solution(vector<int> numbers, string hand) {
    //번호판을 2차원 배열로 생각하면 x값끼리의 차 + y값 끼리의 차 = 이동거리
    //x값은 3으로 나눈값 y값은 3으로 나눈 나머지 -1 값이다.
    int left = 10; //*은 위치상 10번 위치
    int right = 12; //#은 위치상 12번 위치
    string answer = "";
    for (int n : numbers)
    {
        n = n == 0 ? 11 : n; //0은 위치상 11번 위치
        switch (n)
        {
        case 1:
        case 4:
        case 7:
            left = n;
            answer += "L";
            break;
        case 3:
        case 6:
        case 9:
            right = n;
            answer += "R";
            break;
        default:
            if (getGap(left, n) == getGap(right, n)) //거리가 같으면
            {
                if (hand == "left")
                {
                    left = n;
                    answer += "L";
                }
                else
                {
                    right = n;
                    answer += "R";
                }
            }
            else if (getGap(left, n) < getGap(right, n))
            {
                left = n;
                answer += "L";
            }
            else
            {
                right = n;
                answer += "R";
            }
            break;
        }
    }
    return answer;
}