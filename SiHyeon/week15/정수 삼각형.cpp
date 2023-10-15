#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle)
{
    int answer = 0;
    // 밑에서부터 위에 더했을때 큰 값을 더해줌
    for (int i = triangle.size() - 1; i > 0; i--)
    {
        for (int j = 0; j < triangle[i].size() - 1; j++)
        {
            if (triangle[i][j] > triangle[i][j + 1])
                triangle[i - 1][j] += triangle[i][j];
            else
                triangle[i - 1][j] += triangle[i][j + 1];
        }
    }
    answer = triangle[0][0];
    return answer;
}