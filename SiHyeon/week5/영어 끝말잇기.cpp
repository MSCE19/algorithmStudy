#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer = { 0,0 };
    string str;
    for (int i = 0; i < words.size(); i++)
    {
        int findIndex = str.find(words[i]);
        //단어가 한글자, 앞단어와 안이어지는 단어, 겹치는 단어 체크
        if (words[i].size() == 1
            || (!str.empty() && str[str.size() - 2] != words[i][0]
                || findIndex != string::npos && str[findIndex - 1] == '\"'))
        {
            answer[0] = i % n + 1;
            answer[1] = (i + n) / n;
            break;
        }
        str += "\"" + words[i] + "\""; //"" 없이 단어를 이으면 겹치는거 체크할때 helloone 이면 loo라는 단어가 오면 문제가 생기기 때문
    }

    return answer;
}