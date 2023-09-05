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
        weight = people[i]; //�ϴ� ���� ���ſ� ����� �¿�
        if (weight + people[begin] <= limit) //������ ��� �Ѹ�� Ż���ִ��� Ȯ��
            begin++;
        answer++;
    }
    return answer;
}