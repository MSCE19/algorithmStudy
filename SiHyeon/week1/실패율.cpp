#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int people = stages.size(); //스테이지 도달한 사람 수
    multimap<double, int, greater<double>> M_stage; //중복 가능한한 map, key=실패율, value=스테이지
    for (int target = 1; target <= N; target++)
    {
        int i_count = count(stages.begin(), stages.end(), target); //아직 클리어 못한 수
        double fail = people != 0 ? ((double)i_count / (double)people) : 0;
        M_stage.insert(pair<double, int>(fail, target));

        people -= i_count;
    }
    for (auto v : M_stage)
    {
        answer.push_back(v.second);
    }
    return answer;
}