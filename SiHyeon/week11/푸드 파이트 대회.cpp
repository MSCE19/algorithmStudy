#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food)
{
    string answer = "0";
    for (int i = food.size() - 1; i > 0; i--)
    {
        string temp = "";
        temp.append((int)food[i] / 2, i + '0');
        answer = temp + answer + temp;
    }
    return answer;
}