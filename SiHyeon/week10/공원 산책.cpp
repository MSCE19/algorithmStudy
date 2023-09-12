#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes)
{
    vector<int> answer;
    int x = 0;
    int y = 0;
    // 시작 점
    for (int i = 0; i < park.size(); i++)
    {
        int index = park[i].find("S");
        if (index != string::npos)
        {
            x = index;
            y = i;
            break;
        }
    }
    // 공원 크기
    int MaxX = park[0].size();
    int MaxY = park.size();
    for (auto call : routes)
    {
        int n = call[2] - '0'; // 이동 거리
        switch (call[0])
        {
        case 'E':
            for (int i = 0;; i++)
            {
                if (x + i >= MaxX || park[y][x + i] == 'X') // 갈수있는지 확인
                    break;
                if (i >= n) // 끝까지 갈수잇으면 이동
                {
                    x += n;
                    break;
                }
            }
            break;
        case 'W':
            for (int i = 0;; i++)
            {
                if (x - i < 0 || park[y][x - i] == 'X')
                    break;
                if (i >= n)
                {
                    x -= n;
                    break;
                }
            }
            break;
        case 'S':
            for (int i = 0;; i++)
            {
                if (y + i >= MaxY || park[y + i][x] == 'X')
                    break;
                if (i >= n)
                {
                    y += n;
                    break;
                }
            }
            break;
        case 'N':
            for (int i = 0;; i++)
            {
                if (y - i < 0 || park[y - i][x] == 'X')
                    break;
                if (i >= n)
                {
                    y -= n;
                    break;
                }
            }
            break;
        }
    }
    answer.push_back(y);
    answer.push_back(x);
    return answer;
}