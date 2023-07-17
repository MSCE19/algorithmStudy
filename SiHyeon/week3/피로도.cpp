#include <string>
#include <vector>

using namespace std;

int dfs(int k, int count, vector<vector<int>> dungeons, int visited[])
{
    static int max = 0;
    for (int i = 0; i < dungeons.size(); i++)
    {
        //방문한적이 없고 최소피로도 보다 많은 경우 즉, 방문 가능한 경우
        if (!visited[i] && k >= dungeons[i][0])
        {
            visited[i] = true;
            max = dfs(k - dungeons[i][1], count + 1, dungeons, visited);
            visited[i] = false;
        }
    }
    return count > max ? count : max;
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    int visited[8] = { false, };
    answer = dfs(k, 0, dungeons, visited);
    return answer;
}