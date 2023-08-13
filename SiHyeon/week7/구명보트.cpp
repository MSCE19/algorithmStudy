#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    int weight = 0;
    int begin = 0;
    for (int i = people.size() - 1; i >= begin; i--)
    {
        weight = people[i]; //일단 제일 무거운 사람을 태움
        if (weight + people[begin] <= limit) //가벼운 사람 한명더 탈수있는지 확인
            begin++;
        answer++;
    }
    return answer;
}