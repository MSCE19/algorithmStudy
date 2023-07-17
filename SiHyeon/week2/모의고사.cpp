#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> first = { 1, 2, 3, 4, 5 };
    vector<int> second = { 2,1,2,3,2,4,2,5 };
    vector<int> third = { 3,3,1,1,2,2,4,4,5,5 };
    vector<int> score = { 0,0,0 };
    for (int i = 0; i < answers.size(); i++)
    {
        score[0] = first[i % first.size()] == answers[i] ? score[0] + 1 : score[0];
        score[1] = second[i % second.size()] == answers[i] ? score[1] + 1 : score[1];
        score[2] = third[i % third.size()] == answers[i] ? score[2] + 1 : score[2];
    }
    for (int i = 0; i < score.size(); i++)
    {
        if (answer.empty() || score[i] == score[answer.back() - 1])
            answer.push_back(i + 1);
        else if (score[i] > score[answer.back() - 1])
        {
            answer.clear();
            answer.push_back(i + 1);
        }
    }
    return answer;
}