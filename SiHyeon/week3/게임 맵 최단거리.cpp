#include<vector>
#include<queue>
using namespace std;

class Node
{
public:
    Node(int y, int x, int step)
    {
        this->x = x;
        this->y = y;
        this->step = step;
    };
    int x;
    int y;
    int step;
};

int solution(vector<vector<int> > maps)
{
    //이동방향
    int nextX[] = { 1,-1,0,0 };
    int nextY[] = { 0,0,1,-1 };

    //방문한 큐
    queue<Node> q;

    //시작점
    q.push(*(new Node(0, 0, 1)));
    maps[0][0] = 0;

    //BFS
    while (!q.empty())
    {
        Node current = q.front();
        q.pop();

        //목표 도달
        if (current.y == maps.size() - 1
            && current.x == maps[0].size() - 1)
            return current.step;

        //4방향 체크
        for (int i = 0; i < 4; i++) {
            int y = current.y + nextY[i];
            int x = current.x + nextX[i];
            if (y >= 0 && y < maps.size()
                && x >= 0 && x < maps[0].size()
                && maps[y][x] == 1) {
                // next 방문
                q.push(*(new Node(y, x, current.step + 1)));
                maps[y][x] = 0;
            }
        }
    }
    return -1;
}