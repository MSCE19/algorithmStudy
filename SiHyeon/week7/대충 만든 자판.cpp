#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for (auto t : targets) //처음 target부터
    {
        int count = 0;
        for (auto c : t) //한 문자별로
        {
            int mindex = 0; //누르는 최소횟수
            //몇번키를 누를지 찾아야함.
            //모든 키를 순환하면서 최솟값 찾아야함.
            for (int i = 0; i < keymap.size(); i++)
            {
                int index = keymap[i].find(c);
                if (index != string::npos && (mindex == 0 || mindex > index + 1))
                {
                    mindex = index + 1;
                }
            }
            if (mindex != 0) //찾은경우
                count += mindex;
            else //못찾은 경우 그대로 0
            {
                count = -1;
                break;
            }
        }
        answer.push_back(count);
    }
    return answer;
}