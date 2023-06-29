#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    //photo배열에서 모든 값을 꺼낸다
    for (auto page : photo)
    {
        int score = 0; //사진별 그리움 점수
        for (auto people : page)
        {
            //people이름을 name벡터에서 찾아본다.
            auto index = find(name.begin(), name.end(), people);
            if (index != name.end()) //존재하면 인덱스 구해서 더함
                score += yearning[index - name.begin()];
        }
        answer.push_back(score);
    }
    return answer;
}