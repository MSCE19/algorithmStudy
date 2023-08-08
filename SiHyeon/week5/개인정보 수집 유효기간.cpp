#include <string>
#include <vector>

using namespace std;

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    int index = 1;
    for (auto privacy : privacies)
    {
        char str_type = privacy.back(); //종류을 가져온다
        string collectionDate = privacy.substr(0, 10);
        int expirationDate = 0;
        int yearDiff = 0;
        int monthDiff = 0;
        int dayDiff = 0;
        for (auto term : terms)
        {
            if (term.front() == str_type) //종류의 유효기간을 가져온다.
            {
                expirationDate = stoi(term.substr(2));
                break;
            }
        }
        //년, 달, 일 마다 계약한 날과 오늘날의 차이를 구한다.
        yearDiff = stoi(today.substr(0, 4)) - stoi(collectionDate.substr(0, 4));
        monthDiff = stoi(today.substr(5, 2)) - stoi(collectionDate.substr(5, 2));
        dayDiff = stoi(today.substr(8, 2)) - stoi(collectionDate.substr(8, 2));

        if (yearDiff * 12 + monthDiff > expirationDate
            || (yearDiff * 12 + monthDiff == expirationDate && dayDiff >= 0))
        {
            answer.push_back(index);
        }
        index++;
    }
    return answer;
}