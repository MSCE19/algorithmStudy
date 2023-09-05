#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper)
{
    vector<int> answer;
    int lux = -1, luy = -1, rdx = -1, rdy = -1;
    for (int i = 0; i < wallpaper.size(); i++)
    {
        for (int j = 0; j < wallpaper[i].size(); j++)
        {
            // lux
            if (wallpaper[i][j] == '#' && lux == -1)
                lux = i;
            // luy
            if (wallpaper[i][j] == '#' && (luy == -1 || luy > j))
                luy = j;
            // rdx
            if (wallpaper[i][j] == '#' && (rdx == -1 || rdx < i + 1))
                rdx = i + 1;
            // rdy
            if (wallpaper[i][j] == '#' && (rdy == -1 || rdy < j + 1))
                rdy = j + 1;
        }
    }
    answer.push_back(lux);
    answer.push_back(luy);
    answer.push_back(rdx);
    answer.push_back(rdy);
    return answer;
}